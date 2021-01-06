package edu.gsu.GUI;

import edu.gsu.common.Customer;
import edu.gsu.common.Action;
import edu.gsu.common.Flight;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AccountPanel extends Application {

	Image image = new Image("airport.jpg", 1600, 700, false, false);
	BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	Background bg = new Background(bgi);

	private TableView<Flight> tvFlights;
	private TableColumn<Flight, String> colFlightID;
	private TableColumn<Flight, String> colAirline;
	private TableColumn<Flight, String> colDepart;
	private TableColumn<Flight, String> colArrive;
	private TableColumn<Flight, String> colDepTime;
	private TableColumn<Flight, String> colArrTime;
	private TableColumn<Flight, String> colDepDate;

	private TableView<Flight> tvAllFlights;
	private TableColumn<Flight, String> colAllFlightID;
	private TableColumn<Flight, String> colAllAirline;
	private TableColumn<Flight, String> colAllDepart;
	private TableColumn<Flight, String> colAllArrive;
	private TableColumn<Flight, String> colAllDepTime;
	private TableColumn<Flight, String> colAllArrTime;
	private TableColumn<Flight, String> colAllDepDate;

	Scene acctScene;
	Stage window;

	Label user;

	Label myFlights;
	Button delete;
	Button update;

	Label allFlights;
	Button book;
	Button showAll;
	Button search;

	Label labDep;
	Label labArr;
	Label labTime;
	Label labAir;
	Label labDepDate;

	TextField depLocation;
	TextField arrLocation;
	TextField departHour;
	ComboBox airline;
	ComboBox departMo;
	ComboBox departDay;
	ComboBox departYear;
	//new ComboBox(FXCollections.observableArrayList());

	Button btLogout;

	private Customer customer;
	private Flight flight = new Flight();
	private ObservableList<Flight> blank = FXCollections.observableArrayList();

	public AccountPanel (Customer customer) {
		this.customer = customer;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		blank.add(new Flight("","","","","","",""));

		String airlines[] = { null,"Delta", "American", "United", "EVA", "SouthWest" };
		String months[] = { null,"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		String days[] = { null,"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String years[] = { null,"2021", "2022"};

		window = primaryStage;
		window.setTitle("BoBo Booking (cust_no.: " + customer.getRoyaltyNumber() + ")");
		window.setResizable(false);
		window.setHeight(600);
		window.setWidth(1250);

		primaryStage.getTitle();

		btLogout = new Button("LOGOUT");
		btLogout.setOnAction(e -> logout());

		tvFlights = new TableView<>();
		colFlightID = new TableColumn<>("Flight ID");
		colAirline = new TableColumn<>("Airline");
		colDepart = new TableColumn<>("Depart. City");
		colArrive = new TableColumn<>("Arrive City");
		colDepTime = new TableColumn<>("Depart. Time");
		colArrTime = new TableColumn<>("Arrive Time");
		colDepDate = new TableColumn<>("Date");

		colFlightID.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightID"));
		colAirline.setCellValueFactory(new PropertyValueFactory<Flight, String>("airline"));
		colDepart.setCellValueFactory(new PropertyValueFactory<Flight, String>("departure"));
		colArrive.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrival"));
		colDepTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("depTime"));
		colArrTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrTime"));
		colDepDate.setCellValueFactory(new PropertyValueFactory<Flight, String>("depDate"));

		colFlightID.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.1));
		colAirline.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.191));
		colDepart.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.14));
		colArrive.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.14));
		colDepTime.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.14));
		colArrTime.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.14));
		colDepDate.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.14));

		colFlightID.setResizable(false);
		colAirline.setResizable(false);
		colDepart.setResizable(false);
		colArrive.setResizable(false);
		colDepTime.setResizable(false);
		colArrTime.setResizable(false);
		colDepDate.setResizable(false);

		tvFlights.getColumns().addAll(colFlightID,colAirline,colDepart,
				colArrive,colDepTime,colArrTime,colDepDate);

		tvFlights.setPrefWidth(575);
		tvFlights.setItems(blank);

		tvAllFlights = new TableView<>();
		colAllFlightID = new TableColumn<>("Flight ID");
		colAllAirline = new TableColumn<>("Airline");
		colAllDepart = new TableColumn<>("Depart. City");
		colAllArrive = new TableColumn<>("Arrive City");
		colAllDepTime = new TableColumn<>("Depart. Time");
		colAllArrTime = new TableColumn<>("Arrive Time");
		colAllDepDate = new TableColumn<>("Date");

		colAllFlightID.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightID"));
		colAllAirline.setCellValueFactory(new PropertyValueFactory<Flight, String>("airline"));
		colAllDepart.setCellValueFactory(new PropertyValueFactory<Flight, String>("departure"));
		colAllArrive.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrival"));
		colAllDepTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("depTime"));
		colAllArrTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrTime"));
		colAllDepDate.setCellValueFactory(new PropertyValueFactory<Flight, String>("depDate"));

		colAllFlightID.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.1));
		colAllAirline.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.191));
		colAllDepart.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.14));
		colAllArrive.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.14));
		colAllDepTime.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.14));
		colAllArrTime.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.14));
		colAllDepDate.prefWidthProperty().bind(tvFlights.widthProperty().multiply(0.14));

		colAllFlightID.setResizable(false);
		colAllAirline.setResizable(false);
		colAllDepart.setResizable(false);
		colAllArrive.setResizable(false);
		colAllDepTime.setResizable(false);
		colAllArrTime.setResizable(false);
		colAllDepDate.setResizable(false);

		tvAllFlights.getColumns().addAll(colAllFlightID,colAllAirline,colAllDepart,
				colAllArrive,colAllDepTime,colAllArrTime,colAllDepDate);

		tvAllFlights.setPrefWidth(575);
		tvAllFlights.setItems(blank);

		user = new Label("HELLO " + customer.getLastName() + ", " + customer.getFirstName() + "!");
		myFlights = new Label("My Flights");
		allFlights = new Label("Available Flights");

		user.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 24));
		myFlights.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 20));
		allFlights.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 20));

		user.setStyle("-fx-text-fill: White;");
		myFlights.setStyle("-fx-text-fill: White;");
		allFlights.setStyle("-fx-text-fill: White;");

		labDep = new Label("FROM:");
		labArr = new Label("TO:");
		labTime = new Label("AT:");
		labAir = new Label("AIRLINE:");
		labDepDate = new Label("DATE:");

		labDep.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 16));
		labArr.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 16));
		labTime.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 16));
		labAir.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 16));
		labDepDate.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 16));

		labDep.setStyle("-fx-text-fill: White;");
		labArr.setStyle("-fx-text-fill: White;");
		labTime.setStyle("-fx-text-fill: White;");
		labAir.setStyle("-fx-text-fill: White;");
		labDepDate.setStyle("-fx-text-fill: White;");

		depLocation = new TextField();
		depLocation.setPromptText("ex: NYC");
		depLocation.setPrefSize(80,25);
		arrLocation = new TextField();
		arrLocation.setPromptText("ex: SFO");
		arrLocation.setPrefSize(80,25);
		departHour = new TextField();
		departHour.setPromptText("hr");
		departHour.setPrefSize(45,25);
		airline = new ComboBox(FXCollections.observableArrayList(airlines));
		airline.setPrefSize(150, 25);
		departMo = new ComboBox(FXCollections.observableArrayList(months));
		departMo.setPrefSize(75, 25);
		departDay = new ComboBox(FXCollections.observableArrayList(days));
		departDay.setPrefSize(75, 25);
		departYear = new ComboBox(FXCollections.observableArrayList(years));
		departYear.setPrefSize(100, 25);

		search = new Button("Search");
		search.setOnAction(e -> {
			String air;
			String dep;
			String arr;
			String depT;
			String depD;

			if (airline.getSelectionModel().isEmpty())
				air = null;
			else
				air = (String) airline.getSelectionModel().getSelectedItem();

			if (depLocation.getText().isBlank())
				dep = null;
			else
				dep = depLocation.getText();

			if (arrLocation.getText().isBlank())
				arr = null;
			else
				arr =  arrLocation.getText();

			if (departMo.getValue() == null || departDay.getValue() == null || departYear.getValue() == null) {
				depD = null;
			} else {
				depD = departMo.getValue() + "/" + departDay.getValue() + "/" + departYear.getValue();
			}

			if (departHour.getText().isBlank())
				depT = null;
			else
				depT = departHour.getText()+"%";

			searching(air,dep,arr,depT,depD);
		});

		book = new Button("Book");
		book.setOnAction(e -> {
			flight = tvAllFlights.getSelectionModel().getSelectedItem();
			bookFlight(customer, flight);
			showFlight(customer);
		});

		update = new Button("Update");
		update.setOnAction(e -> showFlight(customer));

		delete = new Button("Delete");
		delete.setOnAction(e -> {
			flight = tvFlights.getSelectionModel().getSelectedItem();
			deleteFlight(customer, flight);
			showFlight(customer);
		});

		showAll = new Button("Show All");
		showAll.setOnAction(e -> showAll(customer));

		HBox hSearch1 = new HBox();
		hSearch1.getChildren().addAll(departMo, departDay, departYear);
		hSearch1.setSpacing(5);

		HBox hSearch2 = new HBox();
		hSearch2.setSpacing(5);
		hSearch2.getChildren().addAll(departHour);

		HBox all = new HBox();
		all.getChildren().addAll(labDep,depLocation,labArr,arrLocation,labAir,airline,labDepDate,hSearch1,labTime,hSearch2);
		all.setSpacing(15);

		Pane acct = new Pane();

		all.setLayoutX(60);
		all.setLayoutY(75);

		search.setLayoutX(1100);
		search.setLayoutY(75);
		update.setLayoutX(488);
		update.setLayoutY(120);
		delete.setLayoutX(550);
		delete.setLayoutY(120);
		showAll.setLayoutX(1097);
		showAll.setLayoutY(120);
		book.setLayoutX(1167);
		book.setLayoutY(120);
		myFlights.setLayoutX(25);
		myFlights.setLayoutY(120);
		tvFlights.setLayoutX(25);
		tvFlights.setLayoutY(150);
		allFlights.setLayoutX(635);
		allFlights.setLayoutY(120);
		tvAllFlights.setLayoutX(635);
		tvAllFlights.setLayoutY(150);
		btLogout.setLayoutX(1150);
		btLogout.setLayoutY(25);
		user.setLayoutX(25);
		user.setLayoutY(20);
		acct.getChildren().addAll(tvFlights, tvAllFlights, search, update, delete, showAll,
				book, all, myFlights, allFlights, btLogout, user);
		acct.setBackground(bg);
		acctScene = new Scene(acct);
		window.setScene(acctScene);

		primaryStage.show();

	}

	public ObservableList<Flight> searching
			(String air, String dep, String arr, String depT, String depD){

		ObservableList<Flight> flights = FXCollections.observableArrayList();

		try {
			flights = PopUP.searching(air,dep,arr,depT,depD);
			tvAllFlights.setItems(flights);
		}

		catch (Exception e) {

			Alert a1 = new Alert(Alert.AlertType.ERROR);
			a1.setTitle("Search Fail");
			a1.setHeaderText("Search Fail, please try again");
			a1.setContentText(e.getMessage());

			a1.showAndWait();

		}

		return flights;

	}

	public ObservableList<Flight> showAll(Customer c1) {

		c1.setAction(Action.ALL_FLIGHTS);
		ObservableList<Flight> flights = FXCollections.observableArrayList();

		try {
			flights = PopUP.findFlight(c1);
			tvAllFlights.setItems(flights);
		}

		catch (Exception e) {

			Alert a1 = new Alert(Alert.AlertType.ERROR);
			a1.setTitle("Search Fail");
			a1.setHeaderText("Search Fail, please try again");
			a1.setContentText(e.getMessage());

			a1.showAndWait();

		}

		return flights;

	}

	public void showFlight(Customer c1) {

		c1.setAction(Action.GET_MY_FLIGHTS);

		try {
			ObservableList<Flight> flights = PopUP.findFlight(c1);
			tvFlights.setItems(flights);
		}

		catch (Exception e) {

			Alert a1 = new Alert(Alert.AlertType.ERROR);
			a1.setTitle("Search Fail");
			a1.setHeaderText("Search Fail, please try again");
			a1.setContentText(e.getMessage());

			a1.showAndWait();

		}

	}

	public void deleteFlight(Customer c1, Flight f1) {
		PopUP.deleteFlight(c1,f1);
	}

	public void bookFlight(Customer c1, Flight f1) {
		PopUP.bookFlight(c1,f1);
	}

	public void logout(){
		Stage stage = (Stage) btLogout.getScene().getWindow();

		stage.close();

		StartingPanel start = new StartingPanel();
		try {
			start.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
