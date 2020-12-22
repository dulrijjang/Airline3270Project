package edu.gsu.GUI;

import static edu.gsu.bizlogic.BizLogicProcess.process;

import java.util.Random;

import edu.gsu.common.Customer;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;

public class RegisterPanel extends Application {
	
	 private Customer c1 = new Customer();
	 
	 Image image = new Image("flight.jpg");
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
	 TextField royaltyNumber;

    public RegisterPanel() {

      
    }
 
    public void regiInput (ActionEvent event) {

            Random rand = new Random();
            String royaltyNumber = rand.nextInt(10000) + "";

            c1.setRoyaltyNumber(royaltyNumber); // royaltyNumber;
            c1.setFirstName(fnText.getText()); // firstName;
            c1.setLastName(lnText.getText()); // lastName;
            c1.setLoginID(usnText.getText()); // loginID;
            c1.setPassword(pswText.getText()); // password;
            c1.setEmail(emText.getText()); // email;
            c1.setAddress(addText.getText()); // address;
            c1.setZip(zipText.getText()); // zip;
            c1.setState(stateText.getText()); //state;
            c1.setSSN(ssnText.getText()); //ssn;
            c1.setSecurityQ(sqText.getText()); // securityQ;
            c1.setSecurityA(saText.getText()); // securityA;

            c1.setAction("register");

            try {
                process(c1);
            } 
            
            catch (Exception e) {
               e.printStackTrace();
            }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	window = primaryStage;
    	window.setTitle("BoBo Air Registration");
    	
    	username = new Label("LoginID:");
    	password = new Label("Password:");
    	firstName = new Label("First Name:");
    	lastName = new Label("Last Name:");
    	email = new Label("Email:");
    	address = new Label("Address:");
    	zip = new Label("ZIP Code:");
    	state = new Label("State:");
    	ssn = new Label("SSN:");
    	securityQ = new Label("Security Question:");
    	securityA = new Label("Security Answer:");
    	
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
    	royaltyNumber = new TextField();
    	
    	btCreate = new Button("Create");
    	btCreate.setOnAction(e-> {
    	
    		RegisterPanel rp = new RegisterPanel();
    		rp.regiInput(e);	
    				
    	});
    	
    	btBack = new Button("Back");
    	btBack.setOnAction(e-> {
    		
    		Stage stage = (Stage) btBack.getScene().getWindow();
    		
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
	
    public void main(String [] args) {
    	
    	launch(args);
    	
    }
  
}
