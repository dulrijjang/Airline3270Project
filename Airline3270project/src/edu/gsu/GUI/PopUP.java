package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.GUI.AccountPanel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class PopUP {

	public static boolean confirmation (Customer c1) {

		try {

			BizLogicProcess.process1(c1);

		}

		catch (Exception e) {

			Alert a1 = new Alert(AlertType.ERROR);
			a1.setTitle("Login Fail");
			a1.setHeaderText("Login Fail, please try again or click 'Forgot Password'");
			a1.setContentText(e.getMessage());

			a1.showAndWait();
			return false;

		}

		return true;

	}

	public static String find(Customer c1) {

		String info = null;

		try {

			info = BizLogicProcess.processQ(c1);

		}

		catch (Exception e) {

			Alert a1 = new Alert(AlertType.ERROR);
			a1.setTitle("Search Fail");
			a1.setHeaderText("Search Fail, please try again");
			a1.setContentText(e.getMessage());

			a1.showAndWait();
			return "No matching ID";

		}

		return info;

	}

	public static ObservableList<Flight> findFlight(Customer c1) {

		ObservableList<Flight> flights = FXCollections.observableArrayList();

		try {
			flights = BizLogicProcess.process3(c1);

		}

		catch (Exception e) {

			Alert a1 = new Alert(AlertType.ERROR);
			a1.setTitle("Search Fail");
			a1.setHeaderText("Search Fail, please try again");
			a1.setContentText(e.getMessage());

			a1.showAndWait();

		}

		return flights;

	}

	public static void deleteFlight(Customer c1, Flight f1) {
		try {
			BizLogicProcess.process2(c1, f1);
		}
		catch (Exception e) {

			Alert a1 = new Alert(AlertType.ERROR);
			a1.setTitle("Add Fail");
			a1.setHeaderText("Add Fail, please try again");
			a1.setContentText(e.getMessage());

			a1.showAndWait();

		}

	}

}