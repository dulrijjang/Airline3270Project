package edu.gsu.GUI;

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
	
	Stage window;
	Image image = new Image("flight2.jpg");
	BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	Background bg = new Background(bgi);
	
	Button btLogin;
	Button btRegi;
	Button btFgot;
	TextField tfname;
	PasswordField pfpsw;
	
    public static void main(String[] args) {
    	
    	launch(args);

    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		window.setTitle("BoBo Airline Login");
		
		Label lname = new Label("Login ID:");
		lname.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 15));
		lname.setStyle("-fx-text-fill: Black;");

		Label lpsw = new Label("Password:");
		lpsw.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 15));
		lpsw.setStyle("-fx-text-fill: Black;");
		
		
		tfname = new TextField();
		pfpsw = new PasswordField();
		
		btLogin = new Button("Login");
		btLogin.setOnAction(e-> {
			
			LoginPanel lp = new LoginPanel();
			
			lp.btLoginAction(e);
			
		});
		
		btRegi = new Button("Register");
		btRegi.setOnAction(e-> {
			
			RegisterPanel rp = new RegisterPanel();
			
			try {
				rp.start(primaryStage);
			} 
			catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
		});
		
		
		
		
		
		btFgot = new Button("Forgot Password");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10,10,10,10));
		grid.setHgap(10.0);
		grid.setVgap(10.0);
		GridPane.setConstraints(lname, 0,0,1,1);
		GridPane.setConstraints(lpsw, 0,1,1,1);
		GridPane.setConstraints(tfname,1,0,1,1);
		GridPane.setConstraints(pfpsw,1,1,1,1);
		GridPane.setConstraints(btLogin,0,2,1,1);
		GridPane.setConstraints(btRegi,1,2,1,1);
		GridPane.setConstraints(btFgot,2,2,1,1);
		
		grid.getChildren().addAll(lname,lpsw,tfname,pfpsw,btLogin,btRegi,btFgot);
		
		Scene scene1 = new Scene(grid, 600, 400);
		grid.setBackground(bg);
		
		window.setScene(scene1);
		window.show();
	}

	

}
