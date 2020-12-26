package edu.gsu.GUI;
import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import edu.gsu.GUI.LoginPanel;
import edu.gsu.GUI.AccountPanel;
import edu.gsu.GUI.PopUP;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartingPanel extends Application {
	
	public static Scene scene1;
	
	Image image = new Image("flight.jpg");
	BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	Background bg = new Background(bgi);
	
	Button btLogin = new Button("Login");
	Button btRegi = new Button("Register");
	Button btFgot = new Button("Forgot");
	
    public static void main(String[] args) {
    	
    	launch(args);

    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		primaryStage.setTitle("BoBo Airline Login");
		
		Label lname = new Label("Login ID:");
		lname.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 15));
		lname.setStyle("-fx-text-fill: Black;");

		Label lpsw = new Label("Password:");
		lpsw.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 15));
		lpsw.setStyle("-fx-text-fill: Black;");
		
		
		TextField tfname = new TextField();
		TextField pfpsw = new PasswordField();
		
		
		btLogin.setOnAction(e-> login(tfname.getText(), pfpsw.getText()));
		
		
		btRegi.setOnAction(e-> {
			
			RegisterPanel rp = new RegisterPanel();
			
			try {
				rp.start(primaryStage);
			} 
			catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
		});
			
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10,10,10,10));
		grid.setHgap(15.0);
		grid.setVgap(15.0);
		GridPane.setConstraints(lname, 0,0);
		GridPane.setConstraints(lpsw, 0,1);
		GridPane.setConstraints(tfname,1,0);
		GridPane.setConstraints(pfpsw,1,1);
		GridPane.setConstraints(btLogin,0,2);
		GridPane.setConstraints(btRegi,1,2);
		GridPane.setConstraints(btFgot,2,2);
		
		grid.getChildren().addAll(lname,lpsw,tfname,pfpsw,btLogin,btRegi,btFgot);
		
		scene1 = new Scene(grid, 600, 400);
		grid.setBackground(bg);
		
		primaryStage.setScene(scene1);
		primaryStage.show();
		
	}
	
	public void login(String loginID, String psw) {
		
		Customer c1 = new Customer();
		
		c1.setLoginID(loginID);
		c1.setPassword(psw);
		c1.setAction(Action.LOGIN);
		
		System.out.println("Customer: " + loginID + " " + psw);
		
		boolean loginSuccess = PopUP.confirmation(c1);
		
		if (loginSuccess) {
			
			System.out.println("Successful Login!");
			  
			c1.setAction(Action.GET_FLIGHTS);
			  
			loginSuccess = PopUP.confirmation(c1);
			  
			if (loginSuccess) {
				
				Stage stage = (Stage) btLogin.getScene().getWindow();
				  
				stage.close();
			  
				AccountPanel ap = new AccountPanel(c1);
				  
				try {
					  ap.start(new Stage());
				  } 
				 
				catch (Exception e) {
					  // TODO Auto-generated catch block
					  e.printStackTrace();
				} 
			}		
			
		}
		
	}

	

}
