package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Action;
import edu.gsu.common.Customer;

import javafx.application.Application;
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

	Scene loginScene, regScene, forgotScene;

	Stage window;

	Image image = new Image("jet_plane.jpg", 250, 400, false, false);
	BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	Background bg = new Background(bgi);

	Image logo = new Image("BoBoLogo.jpg", 275, 70, false, false);
	BackgroundImage boboImage = new BackgroundImage(logo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	Background bobo = new Background(boboImage);

	Image image2 = new Image("flight2.jpg", 775, 350, false, false);
	BackgroundImage bgi2 = new BackgroundImage(image2, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	Background bg2 = new Background(bgi2);

	Customer c1 = new Customer();

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

	Label regiConfirm;

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

	//forgot
	Button forgot;
	Button btBack2;

	Label id;
	Label c1Id;
	Label q;
	Label c1Q;
	Label a;
	Label retrievedPsw;
	Label yourPsw;

	TextField answer;

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
		sqText.setPrefSize(300,25);

		securityA = new Label("Security Answer:");
		securityA.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		securityA.setStyle("-fx-text-fill: Black;");
		saText = new TextField();
		saText.setPromptText("ex: Georgia State University");
		saText.setPrefSize(300,25);

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
		btFgot.setOnAction(e-> {
			c1.setLoginID(usnText.getText());
			c1.setSecurityQ(retrieveQ(usnText.getText()));

			c1Id.setText(c1.getLoginID());
			c1Q.setText(c1.getSecurityQ());

			window.setTitle("BoBo Password Retrieval");
			window.setScene(forgotScene);

		});

		btCreate = new Button("Create");
		btCreate.setOnAction(e-> {

			if (usnText1.getText().isBlank() && pswText1.getText().isBlank() && fnText.getText().isBlank() &&
					lnText.getText().isBlank() && emText.getText().isBlank() && addText.getText().isBlank() &&
					zipText.getText().isBlank() && stateText.getText().isBlank() && ssnText.getText().isBlank() &&
					sqText.getText().isBlank() && saText.getText().isBlank()) {
				regiConfirm.setText("All fields required.");
				regiConfirm.setStyle("-fx-text-fill: Red;");
			} else {
				regiInput(usnText1.getText(),pswText1.getText(),fnText.getText(),
						lnText.getText(),emText.getText(),addText.getText(),zipText.getText(),
						stateText.getText(), ssnText.getText(), sqText.getText(), saText.getText());
				regiConfirm.setText("User has been registered.");
				regiConfirm.setStyle("-fx-text-fill: Green;");

			}
		});

		btBack = new Button("Back");
		btBack.setOnAction(e-> {
			window.setScene(loginScene);
			regiConfirm.setText("");
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
		boboLogo.setBackground(bobo);

		AnchorPane log = new AnchorPane(border,loginLayout, boboLogo);
		log.setTopAnchor(border, 0.0);
		log.setLeftAnchor(border, 0.0);
		log.setTopAnchor(loginLayout, 0.0);
		log.setRightAnchor(loginLayout, 0.0);
		log.setTopAnchor(boboLogo, 55.0);
		log.setLeftAnchor(boboLogo, 225.0);
		loginScene = new Scene(log, 650, 400);
		window.setResizable(false);

		regiConfirm = new Label();
		regiConfirm.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));


		Pane regisLayout = new Pane();
		username1.setLayoutX(20);
		username1.setLayoutY(15);
		usnText1.setLayoutX(165);
		usnText1.setLayoutY(10);
		password1.setLayoutX(20);
		password1.setLayoutY(45);
		pswText1.setLayoutX(165);
		pswText1.setLayoutY(40);
		firstName.setLayoutX(20);
		firstName.setLayoutY(75);
		fnText.setLayoutX(165);
		fnText.setLayoutY(70);
		lastName.setLayoutX(20);
		lastName.setLayoutY(105);
		lnText.setLayoutX(165);
		lnText.setLayoutY(100);
		email.setLayoutX(20);
		email.setLayoutY(135);
		emText.setLayoutX(165);
		emText.setLayoutY(130);
		address.setLayoutX(20);
		address.setLayoutY(165);
		addText.setLayoutX(165);
		addText.setLayoutY(160);
		zip.setLayoutX(20);
		zip.setLayoutY(195);
		zipText.setLayoutX(165);
		zipText.setLayoutY(190);
		state.setLayoutX(345);
		state.setLayoutY(195);
		stateText.setLayoutX(390);
		stateText.setLayoutY(190);
		ssn.setLayoutX(20);
		ssn.setLayoutY(225);
		ssnText.setLayoutX(165);
		ssnText.setLayoutY(220);
		securityQ.setLayoutX(20);
		securityQ.setLayoutY(255);
		sqText.setLayoutX(165);
		sqText.setLayoutY(250);
		securityA.setLayoutX(20);
		securityA.setLayoutY(285);
		saText.setLayoutX(165);
		saText.setLayoutY(280);
		btCreate.setLayoutX(195);
		btCreate.setLayoutY(320);
		btBack.setLayoutX(275);
		btBack.setLayoutY(320);
		regiConfirm.setLayoutX(190);
		regiConfirm.setLayoutY(370);

		regisLayout.setStyle("-fx-background-color: #BEE4FD");

		regisLayout.getChildren().addAll(username1,usnText1,password1,pswText1,firstName,fnText,lastName,
				lnText,email,emText,address,addText,zip,zipText,state,stateText,ssn,ssnText,securityQ,
				sqText,securityA,saText,btCreate,btBack,regiConfirm);
		regScene = new Scene(regisLayout, 500, 400);

		window.setScene(loginScene);
		window.show();

		//forgot panel

		id = new Label("Login ID: ");
		id.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		id.setStyle("-fx-text-fill: Black;");
		id.setLayoutX(15);
		id.setLayoutY(15);

		c1Id = new Label();
		c1Id.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		c1Id.setStyle("-fx-text-fill: Blue;");
		c1Id.setLayoutX(150);
		c1Id.setLayoutY(15);

		q = new Label("Security Question: ");
		q.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		q.setStyle("-fx-text-fill: Black;");
		q.setLayoutX(15);
		q.setLayoutY(65);

		c1Q = new Label();
		c1Q.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		c1Q.setStyle("-fx-text-fill: Blue;");
		c1Q.setLayoutX(150);
		c1Q.setLayoutY(65);

		a = new Label("Answer: ");
		a.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		a.setStyle("-fx-text-fill: Black;");
		a.setLayoutX(15);
		a.setLayoutY(115);

		answer = new TextField();
		answer.setPromptText("Answer to your security question");
		answer.setPrefSize(600,25);
		answer.setLayoutX(150);
		answer.setLayoutY(115);

		yourPsw = new Label("Your password is: ");
		yourPsw.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		yourPsw.setStyle("-fx-text-fill: Black;");
		yourPsw.setLayoutX(15);
		yourPsw.setLayoutY(200);

		retrievedPsw = new Label();
		retrievedPsw.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 30));
		retrievedPsw.setStyle("-fx-text-fill: Red;");
		retrievedPsw.setLayoutX(15);
		retrievedPsw.setLayoutY(225);

		forgot = new Button("Forgot Password");
		forgot.setOnAction( e ->
				retrievedPsw.setText(retrievePsw(c1Id.getText(), c1Q.getText(), answer.getText())));
		forgot.setLayoutX(250);
		forgot.setLayoutY(175);

		btBack2 = new Button("Back");
		btBack2.setOnAction(e-> {
			window.setScene(loginScene);
		});
		btBack2.setLayoutX(375);
		btBack2.setLayoutY(175);

		Pane forgotLayout = new Pane();
		forgotLayout.setBackground(bg2);
		forgotLayout.getChildren().addAll(id, c1Id, q, c1Q, a, answer, forgot, yourPsw, retrievedPsw, btBack2);
		forgotScene = new Scene(forgotLayout, 775, 300);

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

			c1.setAction(Action.ROYALTY_NUM);
			c1.setRoyaltyNumber(PopUP.find(c1));

			c1.setAction(Action.FIRST_NAME);
			c1.setFirstName(PopUP.find(c1));

			c1.setAction(Action.LAST_NAME);
			c1.setLastName(PopUP.find(c1));

			Stage stage = (Stage) btLogin.getScene().getWindow();

			stage.close();

			AccountPanel ap = new AccountPanel(c1);
			try {
				ap.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

	public String retrieveQ(String loginID) {

		Customer c1 = new Customer();

		c1.setLoginID(loginID);
		c1.setAction(Action.FIND_QUESTION);

		System.out.println("Customer: " + loginID);
		System.out.println("Password: " + PopUP.find(c1));

		c1.setSecurityQ(PopUP.find(c1));

		return c1.getSecurityQ();

	}

	public String retrievePsw(String loginID, String securityQ, String securityA) {

		Customer c1 = new Customer();

		c1.setLoginID(loginID);
		c1.setSecurityQ(securityQ);
		c1.setSecurityA(securityA);

		c1.setAction(Action.FIND_PASSWORD);

		c1.setPassword(PopUP.find(c1));

		return c1.getPassword();
	}


}
