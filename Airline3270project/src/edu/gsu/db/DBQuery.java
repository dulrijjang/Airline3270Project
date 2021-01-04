package edu.gsu.db;

import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.exceptions.LoginException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;


public class DBQuery {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://127.0.0.1:3306/bobo?user=root?iseTimezone=true&serverTimezone=UTC";
    //need to alter url and insert name of schema/database before ?user
    // "jdbc:mysql://localhost:3306/?user=root?iseTimezone=true&serverTimezone=UTC";
    private static String USN = "root";
    //"root";
    private static String PSW = "Snowy26!";
    //"Xkwhdkf1@";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USN, PSW);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static void login(Customer c1) throws Exception {

        Connection conn = getConnection();

        try {


            // Create a statement
            // PreparedStatement st  = conn.prepareStatement(Query.CREATE);
            PreparedStatement ptmt = conn.prepareStatement(Query.LOGIN);

            ptmt.setString(1, c1.getLoginID());
            ptmt.setString(2, c1.getPassword());

            // Execute a statement
            ResultSet rs1 = ptmt.executeQuery();

            int count = 0;

            // Iterate through the result and print the student names
            while (rs1.next()) {
                System.out.println("Number of Users:" + rs1.getInt(1));
                count = rs1.getInt(1);
            }

            if (count == 0)
                throw new LoginException("Incorrect LoginID or Password!");


        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        } finally {
            conn.close();
        }

    }

    public static String royalty(Customer c1) throws Exception {

        Connection conn = getConnection();
        String royaltyNum = null;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Query.ROYALTY_NUM);

            ptmt.setString(1, c1.getLoginID());

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
                royaltyNum = rs1.getNString(1);
                c1.setSecurityQ(royaltyNum);
            }

            return royaltyNum;

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }

    public static void register(Customer c1) throws Exception {


        Connection conn = getConnection();

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Query.REGISTER);

            ptmt.setString(1, (Math.random() + "")); // royaltyNumber;
            ptmt.setString(2, c1.getFirstName()); // firstName;
            ptmt.setString(3, c1.getLastName()); // lastName;
            ptmt.setString(4, c1.getLoginID()); // loginID;
            ptmt.setString(5, c1.getPassword()); // password;
            ptmt.setString(6, c1.getEmail()); // email;
            ptmt.setString(7, c1.getAddress()); // address;
            ptmt.setString(8, c1.getZip()); // zip;
            ptmt.setString(9, c1.getState()); // state;
            ptmt.setString(10, c1.getSSN()); // ssn;
            ptmt.setString(11, c1.getSecurityQ()); // securityQ;
            ptmt.setString(12, c1.getSecurityA()); // securityA;


            // Execute a statement
            int r1 = ptmt.executeUpdate();
            System.out.print(r1);


        } catch (Exception e) {
            System.out.print(e);
        } finally {
            conn.close();
        }

    }

    public static String question(Customer c1) throws Exception {

        Connection conn = getConnection();
        String securityq = null;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Query.QUESTION);

            ptmt.setString(1, c1.getLoginID());

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
                securityq = rs1.getNString(1);
                c1.setSecurityQ(securityq);
            }

            return securityq;

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }

    public static String password(Customer c1) throws Exception {

        Connection conn = getConnection();
        String password1 = null;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Query.FORGOT);

            ptmt.setString(1, c1.getLoginID());
            ptmt.setString(2, c1.getSecurityQ());
            ptmt.setString(3, c1.getSecurityA());

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
                password1 = rs1.getNString(1);
                c1.setSecurityQ(password1);
            }

            return password1;

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }

    public static ObservableList<Flight> getMyFlights(Customer c1) throws Exception {

        Connection conn = getConnection();
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        Flight flight;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Query.MY_FLIGHTS);

            ptmt.setString(1, c1.getRoyaltyNumber());

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
                flight = new Flight(rs1.getNString("flightID"), rs1.getNString("airline"),
                        rs1.getNString("depart"), rs1.getNString("arrive"),
                        rs1.getNString("depTime"), rs1.getNString("arrTime"),
                        rs1.getNString("depDate"));

                flights.add(flight);
            }

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
        return flights;
    }

    public static void delete(Customer c1, Flight f1) throws Exception {
        Connection conn = getConnection();
        try {
            PreparedStatement ptmt = conn.prepareStatement(Query.SAFE_UPDATE_0);
            ptmt.executeUpdate();

            ptmt = conn.prepareStatement(Query.DELETE_FLIGHT);
            ptmt.setString(1, c1.getRoyaltyNumber());
            ptmt.setString(2, f1.getFlightID());
            ptmt.executeUpdate();

            ptmt = conn.prepareStatement(Query.SAFE_UPDATE_1);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }

    public static ObservableList<Flight> getAllFlights() throws Exception {

        Connection conn = getConnection();
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        Flight flight;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Query.ALL_FLIGHTS);

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
                flight = new Flight(rs1.getNString("flightID"), rs1.getNString("airline"),
                        rs1.getNString("depart"), rs1.getNString("arrive"),
                        rs1.getNString("depTime"), rs1.getNString("arrTime"),
                        rs1.getNString("depDate"));

                flights.add(flight);
            }

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
        return flights;
    }

    public static ObservableList<Flight> searchFlights(Flight f1) throws Exception {

        Connection conn = getConnection();
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        Flight flight;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH);

            ptmt.setString(1, (f1.getAirline() + "%"));
            ptmt.setString(2, (f1.getDeparture() + "%"));
            ptmt.setString(3, (f1.getArrival() + "%"));
            ptmt.setString(4, (f1.getDepTime() + "%"));
            ptmt.setString(5, (f1.getDepDate() + "%"));


            ResultSet rs1 = ptmt.executeQuery();




            while (rs1.next()) {
                flight = new Flight(rs1.getNString("flightID"), rs1.getNString("airline"),
                        rs1.getNString("depart"), rs1.getNString("arrive"),
                        rs1.getNString("depTime"), rs1.getNString("arrTime"),
                        rs1.getNString("depDate"));

                flights.add(flight);
            }

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
        return flights;
    }

    public static void book(Customer c1, Flight f1) throws Exception {
        Connection conn = getConnection();
        try {
            PreparedStatement ptmt = conn.prepareStatement(Query.BOOK_FLIGHT);
            ptmt.setString(1, c1.getRoyaltyNumber());
            ptmt.setString(2, f1.getFlightID());
            ptmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }

    //  public static void search(Flight f1) throws Exception {

    //     Connection conn = null;

    //    try {

    //        Class.forName(DRIVER);
    //        conn = DriverManager.getConnection(URL,USN,PSW);
    //        System.out.println("Connected");

    // Create a statement
    //         switch (f1.getAction()){

    //            case edu.gsu.common.Action.FLIGHT_DEPARTURE:
    //                PreparedStatement ptmt = conn.prepareStatement(Query.FLIGHT_DEPARTURE);
    //                ptmt.setString(1, f1.getDeparture());
    //                break;

    //           case Action.FLIGHT_ARRIVAL:
    //               ptmt = conn.prepareStatement(Query.FLIGHT_ARRIVAL);
    //               ptmt.setString(1, f1.getArrival());
    //               break;

    //           case Action.FLIGHT_MONTHS:
    //              ptmt = conn.prepareStatement(Query.FLIGHT_MONTHS);
    //              ptmt.setString(1, f1.getMonth());
    //             break;

    //           case Action.FLIGHT_DATES:
    //               ptmt = conn.prepareStatement(Query.FLIGHT_DATES);
    //              ptmt.setString(1, f1.getDay());
    //                break;

    //           case Action.FLIGHT_TIMES:
    //              ptmt = conn.prepareStatement(Query.FLIGHT_TIMES);
    //              ptmt.setString(1, f1.getTime());
    //              break;

    //         case Action.FLIGHT_AIRLINE:
    //             ptmt = conn.prepareStatement(Query.FLIGHT_AIRLINE);
    //             ptmt.setString(1, f1.getAirline());
    //              break;
    //     }

    // Execute a statement
    //     ResultSet rs1 = ptmt.executeQuery();

    //     String departure;
    //     String arrival;
    //     String month;
    //      String day;
    //     String time;
    //      String airline;
    //      String flightID;

    //      JFrame frame = new JFrame("BoBo Tours");
    //      frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    //      JPanel panel = new JPanel();
    //      panel.setPreferredSize(new Dimension(300, 200));
    //      panel.setBackground(Color.WHITE);
    //      panel.setLayout(null);
    //      frame.getContentPane().add(panel);
    //      frame.pack();
    //      frame.setVisible(true);

    //      JLabel topBar = new JLabel("Dep     Arr     Mo   Day  Hr   Airline             ID");
    //      topBar.setBounds(20,20,260,25);
    //     panel.add(topBar);

    //     JLabel info;
    ///     int y = 60;
    //     // Iterate through the result and print the student names
    //     while (rs1.next()) {

    //         departure = rs1.getString(1);
    //         info = new JLabel(departure);
    //        info.setBounds(20, y, 30, 20);
    //        panel.add(info);

    //        arrival = rs1.getString(2);
    //        info = new JLabel(arrival);
    //        info.setBounds(60, y, 30, 20);
    //        panel.add(info);


    //         month = rs1.getInt(3) + "";
    //         info = new JLabel(month);
    //         info.setBounds(100, y, 15, 20);
    //         panel.add(info);

    //         day = rs1.getInt(4) + "";
    //         info = new JLabel(day);
    //         info.setBounds(125, y, 15, 20);
    //         panel.add(info);

    //          time = rs1.getInt(5) + "";
    //          info = new JLabel(time);
    //          info.setBounds(150, y, 15, 20);
    //          panel.add(info);

    //          airline = rs1.getString(6);
    //           info = new JLabel(airline);
    //          info.setBounds(175, y, 100, 20);
    //          panel.add(info);

    //          flightID = rs1.getString(7);
    //          info = new JLabel(flightID);
    //          info.setBounds(260, y, 30, 20);
    //          panel.add(info);

    //           y = y + 20;

    //      }


    //    } catch (SQLException e) {

    //        System.out.println(e);
    //        throw e;
    //    }
    //    finally {

    //       conn.close();
    //    }
    //   }

}