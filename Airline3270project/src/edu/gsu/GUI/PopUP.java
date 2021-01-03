package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Customer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


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

	public static String findQ (Customer c1) {

		String secQ = null;

		try {

			secQ = BizLogicProcess.processQ(c1);

		}

		catch (Exception e) {

			Alert a1 = new Alert(AlertType.ERROR);
			a1.setTitle("Search Fail");
			a1.setHeaderText("Search Fail, please try again");
			a1.setContentText(e.getMessage());

			a1.showAndWait();
			return "No matching ID";

		}

		return secQ;

	}

}