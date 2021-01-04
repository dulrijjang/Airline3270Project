package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Customer;
import edu.gsu.common.Action;
import edu.gsu.common.Flight;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AccountPanel extends Application {


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
	TextField departMin;
	ComboBox airline;
	ComboBox departMo;
	ComboBox departDay;
	ComboBox departYear;
	//new ComboBox(FXCollections.observableArrayList());

	Button btLogout;

	private Customer customer;
	private Flight flight = new Flight();

	public AccountPanel (Customer customer) {
		this.customer = customer;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		String airlines[] = { "","Delta", "American", "United", "EVA", "SouthWest" };
		String months[] = { "","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		String days[] = { "","01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String years[] = { "","2021", "2022"};

		window = primaryStage;
		window.setTitle("BoBo Booking (cust_no.: " + customer.getRoyaltyNumber() + ")");
		window.setResizable(false);
		window.setHeight(700);
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
		tvFlights.getColumns().addAll(colFlightID,colAirline,colDepart,
				colArrive,colDepTime,colArrTime,colDepDate);

		tvAllFlights = new TableView<>();
		colAllFlightID = new TableColumn<>("Flight ID");
		colAllAirline = new TableColumn<>("Airline");
		colAllDepart = new TableColumn<>("Depart. City");
		colAllArrive = new TableColumn<>("Arrive City");
		colAllDepTime = new TableColumn<>("Depart. Time");
		colAllArrTime = new TableColumn<>("Arrive Time");
		colAllDepDate = new TableColumn<>("Date");
		tvAllFlights.getColumns().addAll(colAllFlightID,colAllAirline,colAllDepart,
				colAllArrive,colAllDepTime,colAllArrTime,colAllDepDate);

		myFlights = new Label("My Flights");
		allFlights = new Label("Available Flights");

		myFlights.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 18));
		allFlights.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 18));

		labDep = new Label("FROM:");
		labArr = new Label("TO:");
		labTime = new Label("AT:");
		labAir = new Label("AIRLINE:");
		labDepDate = new Label("DATE:");

		labDep.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		labArr.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		labTime.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		labAir.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		labDepDate.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));

		depLocation = new TextField();
		depLocation.setPromptText("ex: NYC");
		depLocation.setPrefSize(80,25);
		arrLocation = new TextField();
		arrLocation.setPromptText("ex: SFO");
		arrLocation.setPrefSize(80,25);
		departHour = new TextField();
		departHour.setPromptText("HH");
		departHour.setPrefSize(45,25);
		departMin = new TextField();
		departMin.setPromptText("MM");
		departMin.setPrefSize(45,25);
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
			flight.setDeparture(depLocation.getText()+"");
			flight.setArrival(arrLocation.getText()+"");
			flight.setAirline(airline.getValue()+"");
			flight.setDepDate(departMo.getValue()+"", departDay.getValue()+"", departYear.getValue()+"");
			flight.setDepTime(departHour.getText()+"", departMin.getText()+"");

			searching(flight);
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
		hSearch2.getChildren().addAll(departHour, departMin);

		HBox all = new HBox();
		all.getChildren().addAll(labDep,depLocation,labArr,arrLocation,labAir,airline,labDepDate,hSearch1,labTime,hSearch2);
		all.setSpacing(15);

		/**
		 VBox labels = new VBox();
		 labels.getChildren().addAll(labDep, labArr, labAir, labDepDate, labTime);
		 labels.setSpacing(15);
		 labels.setStyle("-fx-text-fill: Black;");

		 VBox searches = new VBox();
		 searches.getChildren().addAll(depLocation, arrLocation, airline, hSearch1, hSearch2);
		 searches.setSpacing(15);
		 searches.setPrefSize(50,50);
		 */
		Pane acct = new Pane();

		all.setLayoutX(60);
		all.setLayoutY(175);
/**		labels.setLayoutX(50);
 labels.setLayoutY(25);
 searches.setLayoutX(150);
 searches.setLayoutY(25); */
		search.setLayoutX(1100);
		search.setLayoutY(175);
		update.setLayoutX(475);
		update.setLayoutY(220);
		delete.setLayoutX(537);
		delete.setLayoutY(220);
		showAll.setLayoutX(1100);
		showAll.setLayoutY(220);
		book.setLayoutX(1170);
		book.setLayoutY(220);
		myFlights.setLayoutX(25);
		myFlights.setLayoutY(220);
		tvFlights.setLayoutX(25);
		tvFlights.setLayoutY(250);
		allFlights.setLayoutX(650);
		allFlights.setLayoutY(220);
		tvAllFlights.setLayoutX(650);
		tvAllFlights.setLayoutY(250);
		acct.getChildren().addAll(tvFlights, tvAllFlights, search, update, delete, showAll,
				book, all, myFlights, allFlights, btLogout);

		acctScene = new Scene(acct);
		window.setScene(acctScene);

		primaryStage.show();

	}

	public ObservableList<Flight> searching(Flight f1){

		ObservableList<Flight> flights = FXCollections.observableArrayList(PopUP.searching(f1));

		try {

			colAllFlightID.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightID"));
			colAllAirline.setCellValueFactory(new PropertyValueFactory<Flight, String>("airline"));
			colAllDepart.setCellValueFactory(new PropertyValueFactory<Flight, String>("departure"));
			colAllArrive.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrival"));
			colAllDepTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("depTime"));
			colAllArrTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrTime"));
			colAllDepDate.setCellValueFactory(new PropertyValueFactory<Flight, String>("depDate"));

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
		ObservableList<Flight> flights = PopUP.findFlight(c1);

		try {

			colAllFlightID.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightID"));
			colAllAirline.setCellValueFactory(new PropertyValueFactory<Flight, String>("airline"));
			colAllDepart.setCellValueFactory(new PropertyValueFactory<Flight, String>("departure"));
			colAllArrive.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrival"));
			colAllDepTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("depTime"));
			colAllArrTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrTime"));
			colAllDepDate.setCellValueFactory(new PropertyValueFactory<Flight, String>("depDate"));

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
		ObservableList<Flight> flights = PopUP.findFlight(c1);

		try {

			colFlightID.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightID"));
			colAirline.setCellValueFactory(new PropertyValueFactory<Flight, String>("airline"));
			colDepart.setCellValueFactory(new PropertyValueFactory<Flight, String>("departure"));
			colArrive.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrival"));
			colDepTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("depTime"));
			colArrTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrTime"));
			colDepDate.setCellValueFactory(new PropertyValueFactory<Flight, String>("depDate"));

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
