package edu.gsu.bizlogic;

import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.db.DBQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class BizLogicProcess {

    public static void process1(Customer c1) throws Exception {

        switch (c1.getAction()) {

            case Action.LOGIN:

                DBQuery.login(c1);
                break;

            case Action.REGISTER:

                DBQuery.register(c1);
                break;

        }

    }

    public static String processQ(Customer c1) throws Exception {

        String statement = null;

        switch (c1.getAction()) {
            case Action.FIND_QUESTION:
                statement = DBQuery.question(c1);
                break;
            case Action.FIND_PASSWORD:
                statement = DBQuery.password(c1);
                break;
            case Action.ROYALTY_NUM:
                statement = DBQuery.royalty(c1);
                break;
            case Action.FIRST_NAME:
                statement = DBQuery.first(c1);
                break;
            case Action.LAST_NAME:
                statement = DBQuery.last(c1);
                break;

        }
        return statement;
    }

    public static ObservableList<Flight> process3(Customer c1) throws Exception {

        ObservableList<Flight> flight = FXCollections.observableArrayList();

        switch (c1.getAction()) {
            case Action.GET_MY_FLIGHTS:
                flight = DBQuery.getMyFlights(c1);
                break;
            case Action.ALL_FLIGHTS:
                flight = DBQuery.getAllFlights();
                break;

        }
        return flight;
    }

    public static ObservableList<Flight> searching
            (String air, String dep, String arr, String depT, String depD) throws Exception {

        ObservableList<Flight> flight = DBQuery.searchFlights(air,dep,arr,depT,depD);

        return flight;
    }

    public static void process2(Customer c1, Flight f1) throws Exception {
        DBQuery.delete(c1,f1);
    }

    public static void book(Customer c1, Flight f1) throws Exception {
        DBQuery.book(c1,f1);
    }

}
