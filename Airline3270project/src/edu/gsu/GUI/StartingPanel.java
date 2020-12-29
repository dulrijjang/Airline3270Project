package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Action;
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
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;

public class StartingPanel extends Application {

	Scene loginScene, regScene, acctScene;

	Stage window;

	Image image = new Image("jet_plane.jpg", 250, 400, false, false);
	BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	Background bg = new Background(bgi);

	Image logo = new Image("BoBoLogo.jpg", 275, 70, false, false);
	BackgroundImage bgi2 = new BackgroundImage(logo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	Background bg2 = new Background(bgi2);

	private Customer c1 = new Customer();

	//login
	Button btLogin;
	Button btRegi;
	Button btFgot;

	Label username;
	Label password;

	TextField usnText;
	TextField pswText;

	//registration
	Button btCreate;
	Button btBack;

	Label username1;
	Label password1;
	Label firstName;
	Label lastName;
	Label email;
	Label address;
	Label zip;
	Label state;
	Label ssn;
	Label securityQ;
	Label securityA;

	TextField usnText1;
	TextField pswText1;
	TextField fnText;
	TextField lnText;
	TextField emText;
	TextField addText;
	TextField zipText;
	TextField stateText;
	TextField ssnText;
	TextField sqText;
	TextField saText;

	public static void main(String[] args) { launch(args); }

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("BoBo Airline Login");


		username = new Label("Login ID:");
		username.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		username.setStyle("-fx-text-fill: Black;");
		usnText = new TextField();
		usnText.setPromptText("ex: jdoe78");
		usnText.setPrefSize(300,25);

		username1 = new Label("Login ID:");
		username1.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		username1.setStyle("-fx-text-fill: Black;");
		usnText1 = new TextField();
		usnText1.setPromptText("ex: jdoe78");
		usnText1.setPrefSize(300,25);

		password = new Label("Password:");
		password.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		password.setStyle("-fx-text-fill: Black;");
		pswText = new PasswordField();
		pswText.setPromptText("ex: Unicorns25");
		pswText.setPrefSize(300,25);

		password1 = new Label("Password:");
		password1.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		password1.setStyle("-fx-text-fill: Black;");
		pswText1 = new TextField();
		pswText1.setPromptText("ex: Unicorns25");
		pswText1.setPrefSize(300,25);

		firstName = new Label("First Name:");
		firstName.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		firstName.setStyle("-fx-text-fill: Black;");
		fnText = new TextField();
		fnText.setPromptText("ex: John");
		fnText.setPrefSize(300,25);

		lastName = new Label("Last Name:");
		lastName.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		lastName.setStyle("-fx-text-fill: Black;");
		lnText = new TextField();
		lnText.setPromptText("ex: Doe");
		lnText.setPrefSize(300,25);

		email = new Label("Email:");
		email.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		email.setStyle("-fx-text-fill: Black;");
		emText = new TextField();
		emText.setPromptText("ex: john.doe@gmail.com");
		emText.setPrefSize(300,25);

		address = new Label("Address:");
		address.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		address.setStyle("-fx-text-fill: Black;");
		addText = new TextField();
		addText.setPromptText("ex: 25 Park Place");
		addText.setPrefSize(300,25);

		zip = new Label("ZIP Code:");
		zip.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		zip.setStyle("-fx-text-fill: Black;");
		zipText = new TextField();
		zipText.setPromptText("ex: 12345");
		zipText.setPrefSize(150,25);

		state = new Label("State:");
		state.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		state.setStyle("-fx-text-fill: Black;");
		stateText = new TextField();
		stateText.setPromptText("ex: GA");
		stateText.setPrefSize(50,25);

		ssn = new Label("SSN:");
		ssn.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		ssn.setStyle("-fx-text-fill: Black;");
		ssnText = new TextField();
		ssnText.setPromptText("ex: 123456789");
		ssnText.setPrefSize(300,25);

		securityQ = new Label("Security Question:");
		securityQ.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		securityQ.setStyle("-fx-text-fill: Black;");
		sqText = new TextField();
		sqText.setPromptText("ex: What is the name of your college");
		sqText.setPrefSize(600,25);

		securityA = new Label("Security Answer:");
		securityA.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		securityA.setStyle("-fx-text-fill: Black;");
		saText = new TextField();
		saText.setPromptText("ex: Georgia State University");
		saText.setPrefSize(600,25);

		btLogin = new Button("Login");
		btLogin.setOnAction(e-> {
			login(usnText.getText(), pswText.getText());
			window.setTitle("BoBo Airline Login");
		});

		btRegi = new Button("Register");
		btRegi.setOnAction(e-> {

			window.setScene(regScene);
			window.setTitle("BoBo Air Registration");

		});

		btFgot = new Button("Forgot");

		btCreate = new Button("Create");
		btCreate.setOnAction(e-> regiInput(usnText.getText(),pswText.getText(),fnText.getText(),
				lnText.getText(),emText.getText(),addText.getText(),zipText.getText(),
				stateText.getText(), ssnText.getText(), sqText.getText(), saText.getText()));

		btBack = new Button("Back");
		btBack.setOnAction(e-> {

			window.setScene(loginScene);

		});

		Pane loginLayout = new Pane();
		username.setLayoutX(40);
		username.setLayoutY(150);
		password.setLayoutX(40);
		password.setLayoutY(190);
		usnText.setLayoutX(115);
		usnText.setLayoutY(150);
		pswText.setLayoutX(115);
		pswText.setLayoutY(190);
		btLogin.setLayoutX(175);
		btLogin.setLayoutY(230);
		btLogin.setPrefSize(150,30);
		btFgot.setLayoutX(175);
		btFgot.setLayoutY(270);
		btFgot.setPrefSize(70,30);
		btRegi.setLayoutX(255);
		btRegi.setLayoutY(270);
		btRegi.setPrefSize(70,30);

		loginLayout.setPrefSize(450, 400);
		loginLayout.setStyle("-fx-background-color: white;");
		loginLayout.getChildren().addAll(username, password, usnText, pswText, btLogin, btFgot, btRegi);

		Pane border = new Pane();
		border.setPrefSize(200,400);
		border.setBackground(bg);

		Pane boboLogo = new Pane();
		boboLogo.setPrefSize(400,80);
		boboLogo.setBackground(bg2);

		AnchorPane log = new AnchorPane(border,loginLayout, boboLogo);
		log.setTopAnchor(border, 0.0);
		log.setLeftAnchor(border, 0.0);
		log.setTopAnchor(loginLayout, 0.0);
		log.setRightAnchor(loginLayout, 0.0);
		log.setTopAnchor(boboLogo, 55.0);
		log.setLeftAnchor(boboLogo, 225.0);
		loginScene = new Scene(log, 650, 400);
		window.setResizable(false);

		Pane regisLayout = new Pane();
		username1.setLayoutX(5);
		username1.setLayoutY(0);
		usnText1.setLayoutX(150);
		usnText1.setLayoutY(0);
		password1.setLayoutX(5);
		password1.setLayoutY(30);
		pswText1.setLayoutX(150);
		pswText1.setLayoutY(30);
		firstName.setLayoutX(5);
		firstName.setLayoutY(60);
		fnText.setLayoutX(150);
		fnText.setLayoutY(60);
		lastName.setLayoutX(5);
		lastName.setLayoutY(90);
		lnText.setLayoutX(150);
		lnText.setLayoutY(90);
		email.setLayoutX(5);
		email.setLayoutY(120);
		emText.setLayoutX(150);
		emText.setLayoutY(120);
		address.setLayoutX(5);
		address.setLayoutY(150);
		addText.setLayoutX(150);
		addText.setLayoutY(150);
		zip.setLayoutX(5);
		zip.setLayoutY(180);
		zipText.setLayoutX(150);
		zipText.setLayoutY(180);
		state.setLayoutX(330);
		state.setLayoutY(180);
		stateText.setLayoutX(375);
		stateText.setLayoutY(180);
		ssn.setLayoutX(5);
		ssn.setLayoutY(210);
		ssnText.setLayoutX(150);
		ssnText.setLayoutY(210);
		securityQ.setLayoutX(5);
		securityQ.setLayoutY(240);
		sqText.setLayoutX(150);
		sqText.setLayoutY(240);
		securityA.setLayoutX(5);
		securityA.setLayoutY(270);
		saText.setLayoutX(150);
		saText.setLayoutY(270);
		btCreate.setLayoutX(50);
		btCreate.setLayoutY(300);
		btBack.setLayoutX(150);
		btBack.setLayoutY(300);
		regisLayout.getChildren().addAll(username1,usnText1,password1,pswText1,firstName,fnText,lastName,
				lnText,email,emText,address,addText,zip,zipText,state,stateText,ssn,ssnText,securityQ,
				sqText,securityA,saText,btCreate,btBack);
		regScene = new Scene(regisLayout, 800, 800);

		window.setScene(loginScene);
		window.show();




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

	public void regiInput (String LoginID, String Password, String FirstName, String LastName, String Email, String Address, String ZipCode,
						   String State, String SocialSecurity, String SecurityQuestion, String SecurityAnswer) {

		Random rand = new Random();
		String royaltyNumber = rand.nextInt(10000) + "";

		c1.setRoyaltyNumber(royaltyNumber);
		c1.setFirstName(FirstName);
		c1.setLastName(LastName);
		c1.setLoginID(LoginID);
		c1.setPassword(Password);
		c1.setEmail(Email);
		c1.setAddress(Address);
		c1.setZip(ZipCode);
		c1.setState(State);
		c1.setSSN(SocialSecurity);
		c1.setSecurityQ(SecurityQuestion);
		c1.setSecurityA(SecurityAnswer);
		c1.setAction(Action.REGISTER);

		try {

			BizLogicProcess.process1(c1);;

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}



}
