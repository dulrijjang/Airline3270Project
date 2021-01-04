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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

	Scene acctScene;
	Stage window;

	Label myFlights;
	Button delete;
	Button update;

	private Customer customer;
	private Flight flight;

	public AccountPanel (Customer customer) {

		this.customer = customer;


	}


	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		System.out.print(customer.getRoyaltyNumber());

		primaryStage.getTitle();

		//ObservableList<Flight> flights = FXCollections.observableArrayList();
		//ListView<String> listView = new ListView<>();

		//listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		//for (int i = 0; i < customer.getFlights().size(); i++) {
		//	listView.getItems().add(customer.getFlights().get(i).getAirline());
		//}

		//Button button = new Button("Read selected value");

		//button.setOnAction(e -> {
		//	ObservableList<Integer> selectedIndices = listView.getSelectionModel().getSelectedIndices();

		//	for(Object o : selectedIndices){
		//		System.out.println("Index = " + o + " (" + o.getClass() + ")");
		//		System.out.println(listView.getItems().get((Integer)o));
		//	}
		//});

		//VBox oldList = new VBox(listView, button);

		//myFlights = new Label("My Flights");
		//delete = new Button("Delete Flight");
		//update = new Button("Update List");
		//update.setOnAction(e -> refreshList(customer));
		//Pane tickets = new Pane();
		//tickets.getChildren().addAll(listView, myFlights, delete, update);

		VBox labels = new VBox();
		VBox searches = new VBox();
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

		update = new Button("Update");
		update.setOnAction(e -> showFlight(customer));

		delete = new Button("Delete");
		delete.setOnAction(e -> {
			flight = tvFlights.getSelectionModel().getSelectedItem();
			deleteFlight(customer, flight);
			showFlight(customer);
		});

		AnchorPane acct = new AnchorPane(labels, searches, tvFlights, update, delete);
		acct.setTopAnchor(tvFlights,5.0);
		acct.setLeftAnchor(tvFlights,5.0);
		acctScene = new Scene(acct);
		window.setScene(acctScene);

		//Scene scene = new Scene(oldList, 300, 120);
		//primaryStage.setScene(scene);
		primaryStage.show();

	}

	public ObservableList<Flight> refreshList(Customer c1){

		c1.getRoyaltyNumber();
		c1.setAction(Action.GET_MY_FLIGHTS);

		ObservableList<Flight> flights = FXCollections.observableArrayList(PopUP.findFlight(c1));
		c1.setFlights(flights);
		return flights;

	}

	public ObservableList<Flight> showFlight2(Customer c1) {

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

	//public AccountPanel() {

	// setPreferredSize(new Dimension(300, 200));
	//  setBackground(Color.WHITE);
	//  setLayout(null);

	//  booking = new JButton("Book a Flight");
	//  reservation = new JButton("See Reserved Flights");
	//  update = new JButton("Update a Flight");

	//  booking.setBounds(20, 20, 260, 45);
	//   add(booking);
	//   booking.addActionListener(new AccountPanel.ButtonListener());

	//  reservation.setBounds(20, 70, 260, 45);
	//   add(reservation);
	//   reservation.addActionListener(new AccountPanel.ButtonListener());

	//   update.setBounds(20, 120, 260, 45);
	//   add(update);
	//   update.addActionListener(new AccountPanel.ButtonListener());
	//}

	// class ButtonListener implements ActionListener {

	// @Override
	//  public void actionPerformed(ActionEvent event) {

	//     if(event.getSource() == booking) {

	//         JFrame frame = new JFrame("BoBo Tour Bookings");
	///         frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	//         BookingPanel panel = new BookingPanel();
	///         frame.getContentPane().add(panel);
	//         frame.pack();
	//         frame.setVisible(true);

	//     } else if (event.getSource() == reservation) {

	//         JFrame frame = new JFrame("BoBo Tour Reservations");
	//        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	//        ReservationPanel panel = new ReservationPanel();
	//        frame.getContentPane().add(panel);
	//         frame.pack();
	//         frame.setVisible(true);

	//   } else if (event.getSource() == update) {

	//    }

	//  }
	// }

}
