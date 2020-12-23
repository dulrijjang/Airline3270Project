package edu.gsu.GUI;

import static edu.gsu.bizlogic.BizLogicProcess.process;

import java.util.Random;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Customer;
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

public class RegisterPanel extends Application {
	
	 private Customer c1 = new Customer();
	 
	 Image image = new Image("flight2.jpg");
	 BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	 Background bg = new Background(bgi);
	 
	 Stage window;
	 Button btCreate;
	 Button btBack;
	 Label username ;
	 Label password;
	 Label firstName;
	 Label lastName;
	 Label email;
	 Label address;
	 Label zip;
	 Label state;
	 Label ssn;
	 Label securityQ;
	 Label securityA;
	 
	 TextField usnText; 
 	 PasswordField pswText;
 	 TextField fnText;
 	 TextField lnText;
 	 TextField emText; 
 	 TextField addText;
 	 TextField zipText;
 	 TextField stateText;
 	 TextField ssnText;
 	 TextField sqText;
 	 TextField saText;

    public RegisterPanel() {

      
    }
 
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	window = primaryStage;
    	window.setTitle("BoBo Air Registration");
    	
    	username = new Label("LoginID:");
    	username.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	username.setStyle("-fx-text-fill: Black;");
    	password = new Label("Password:");
    	password.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	password.setStyle("-fx-text-fill: Black;");
    	firstName = new Label("First Name:");
    	firstName.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	firstName.setStyle("-fx-text-fill: Black;");
    	lastName = new Label("Last Name:");
    	lastName.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	lastName.setStyle("-fx-text-fill: Black;");
    	email = new Label("Email:");
    	email.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	email.setStyle("-fx-text-fill: Black;");
    	address = new Label("Address:");
    	address.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	address.setStyle("-fx-text-fill: Black;");
    	zip = new Label("ZIP Code:");
    	zip.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	zip.setStyle("-fx-text-fill: Black;");
    	state = new Label("State:");
    	state.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	state.setStyle("-fx-text-fill: Black;");
    	ssn = new Label("SSN:");
    	ssn.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	ssn.setStyle("-fx-text-fill: Black;");
    	securityQ = new Label("Security Question:");
    	securityQ.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	securityQ.setStyle("-fx-text-fill: Black;");
    	securityA = new Label("Security Answer:");
    	securityA.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 12));
    	securityA.setStyle("-fx-text-fill: Black;");
    	
    	usnText = new TextField();
    	pswText = new PasswordField();
    	fnText = new TextField();
    	lnText = new TextField();
    	emText = new TextField();
    	addText = new TextField();
    	zipText = new TextField();
    	stateText = new TextField();
    	ssnText = new TextField();
    	sqText = new TextField();
    	saText = new TextField();
    	
    	btCreate = new Button("Create");
    	btCreate.setOnAction(e-> regiInput());
    	
    	btBack = new Button("Back");
    	btBack.setOnAction(e-> {
    		
    		Stage stage = (Stage) btBack.getScene().getWindow();
    		
    		stage.setScene(StartingPanel.scene1);
    	
    	});
    	
    	
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	grid.setPadding(new Insets(10,10,10,10));
    	grid.setHgap(15);
    	grid.setVgap(15);
    	GridPane.setConstraints(username, 0, 0);
    	GridPane.setConstraints(usnText, 1, 0);
    	GridPane.setConstraints(password, 0, 1);
    	GridPane.setConstraints(pswText, 1, 1);
    	GridPane.setConstraints(firstName, 0, 2);
    	GridPane.setConstraints(fnText, 1, 2);
    	GridPane.setConstraints(lastName, 0, 3);
    	GridPane.setConstraints(lnText, 1, 3);
    	GridPane.setConstraints(email, 0, 4);
    	GridPane.setConstraints(emText, 1, 4);
    	GridPane.setConstraints(address, 0, 5);
    	GridPane.setConstraints(addText, 1, 5);
    	GridPane.setConstraints(zip, 0, 6);
    	GridPane.setConstraints(zipText, 1, 6);
    	GridPane.setConstraints(state, 0, 7);
    	GridPane.setConstraints(stateText, 1, 7);
    	GridPane.setConstraints(ssn, 0, 8);
    	GridPane.setConstraints(ssnText, 1, 8);
    	GridPane.setConstraints(securityQ, 0, 9);
    	GridPane.setConstraints(sqText, 1, 9);
    	GridPane.setConstraints(securityA, 0, 10);
    	GridPane.setConstraints(saText, 1, 10);
    	GridPane.setConstraints(btCreate, 0, 11);
    	GridPane.setConstraints(btBack, 1, 11);
    	
    	grid.getChildren().addAll(username,usnText,password,pswText,firstName,fnText,lastName,lnText,email,emText,address,addText,
    			zip,zipText,state,stateText,ssn,ssnText,securityQ,sqText,securityA,saText,btCreate,btBack);
    	
    	Scene scene1 = new Scene(grid, 800, 600);
    	grid.setBackground(bg);
    	
    	window.setScene(scene1);
    	window.show();
  
	
    }
    
    public void regiInput () {

        Random rand = new Random();
        String royaltyNumber = rand.nextInt(10000) + "";

        c1.setRoyaltyNumber(royaltyNumber); 
        c1.setFirstName(fnText.getText()); 
        c1.setLastName(lnText.getText()); 
        c1.setLoginID(usnText.getText()); 
        c1.setPassword(pswText.getText()); 
        c1.setEmail(emText.getText()); 
        c1.setAddress(addText.getText()); 
        c1.setZip(zipText.getText()); 
        c1.setState(stateText.getText()); 
        c1.setSSN(ssnText.getText()); 
        c1.setSecurityQ(sqText.getText()); 
        c1.setSecurityA(saText.getText());
        c1.setAction("register");

        try {
        	
            BizLogicProcess.process1(c1);
            
        } 
        
        catch (Exception e) {
        	
           e.printStackTrace();
           
        }

    }

    
	
    public void main(String [] args) {
    	
    	launch(args);
    	
    }
  
}
