package edu.gsu.db;

import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.exceptions.LoginException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

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

    public static String first(Customer c1) throws Exception {

        Connection conn = getConnection();
        String firstN = null;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Query.FIRST_NAME);

            ptmt.setString(1, c1.getLoginID());

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
                firstN = rs1.getNString(1);
                c1.setSecurityQ(firstN);
            }

            return firstN;

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }

    public static String last(Customer c1) throws Exception {

        Connection conn = getConnection();
        String lastN = null;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Query.LAST_NAME);

            ptmt.setString(1, c1.getLoginID());

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
                lastN = rs1.getNString(1);
                c1.setSecurityQ(lastN);
            }

            return lastN;

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

            ptmt.setString(1, c1.getRoyaltyNumber()); // royaltyNumber;
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

    public static ObservableList<Flight> searchFlights
            (String air, String dep, String arr, String depT, String depD) throws Exception {

        Connection conn = getConnection();
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        Flight flight;

        PreparedStatement ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH);
        ResultSet rs1 = null;

        try {

            if (air == null && dep == null && arr == null && depT == null && depD == null) {
                ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_NULL);
            } else if(air != null){
                ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR);
                ptmt.setString(1, air);
                if (dep != null) { //air dep
                    ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_DEP);
                    ptmt.setString(1, air);
                    ptmt.setString(2, dep);
                    if (arr != null) { //air dep arr
                        ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_DEP_ARR);
                        ptmt.setString(1, air);
                        ptmt.setString(2, dep);
                        ptmt.setString(3, arr);
                        if (depT != null) { //air dep arr depT
                            ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_DEP_ARR_TIME);
                            ptmt.setString(1, air);
                            ptmt.setString(2, dep);
                            ptmt.setString(3, arr);
                            ptmt.setString(4, depT);
                            if (depD != null) { //air dep arr depT depD
                                ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH);
                                ptmt.setString(1, air);
                                ptmt.setString(2, dep);
                                ptmt.setString(3, arr);
                                ptmt.setString(4, depT);
                                ptmt.setString(5, depD);
                            }
                        } else if (depD != null) { //air dep arr depD
                            ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_DEP_ARR_DATE);
                            ptmt.setString(1, air);
                            ptmt.setString(2, dep);
                            ptmt.setString(3, arr);
                            ptmt.setString(4, depD);
                        }
                    } else if (depT != null) { //air dep depT
                        ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_DEP_TIME);
                        ptmt.setString(1, air);
                        ptmt.setString(2, dep);
                        ptmt.setString(3, depT);
                        if (depD != null) { //air dep depT depD
                            ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_DEP_TIME_DATE);
                            ptmt.setString(1, air);
                            ptmt.setString(2, dep);
                            ptmt.setString(3, depT);
                            ptmt.setString(4, depD);
                        }
                    } else if (depD != null) { //air dep depD
                        ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_DEP_DATE);
                        ptmt.setString(1, air);
                        ptmt.setString(2, dep);
                        ptmt.setString(3, depD);
                    }
                } else if (arr != null) { //air arr
                    ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_ARR);
                    ptmt.setString(1, air);
                    ptmt.setString(2, arr);
                    if (depT != null) { // air arr depT
                        ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_ARR_TIME);
                        ptmt.setString(1, air);
                        ptmt.setString(2, arr);
                        ptmt.setString(3, depT);
                        if (depD != null) { //air arr depT depD
                            ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_ARR_TIME_DATE);
                            ptmt.setString(1, air);
                            ptmt.setString(2, arr);
                            ptmt.setString(3, depT);
                            ptmt.setString(4, depD);
                        }
                    } else if (depD != null) { //air arr depD
                        ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_ARR_DATE);
                        ptmt.setString(1, air);
                        ptmt.setString(2, arr);
                        ptmt.setString(3, depD);
                    }
                } else if (depT != null) { // air depT
                    ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_TIME);
                    ptmt.setString(1, air);
                    ptmt.setString(2, depT);
                    if (depD != null) { //air depT depD
                        ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_TIME_DATE);
                        ptmt.setString(1, air);
                        ptmt.setString(2, depT);
                        ptmt.setString(3, depD);
                    }
                } else if (depD != null) { // air depD
                    ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_AIR_DATE);
                    ptmt.setString(1, air);
                    ptmt.setString(2, depD);
                }
            } else if (dep != null) { //dep
                ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_DEP);
                ptmt.setString(1, dep);
                if (arr != null) { //dep arr
                    ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_DEP_ARR);
                    ptmt.setString(1, dep);
                    ptmt.setString(2, arr);
                    if (depT != null) { //dep arr depT
                        ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_DEP_ARR_TIME);
                        ptmt.setString(1, dep);
                        ptmt.setString(2, arr);
                        ptmt.setString(3, depT);
                        if (depD != null){ //dep arr depT depD
                            ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_DEP_ARR_TIME_DATE);
                            ptmt.setString(1, dep);
                            ptmt.setString(2, arr);
                            ptmt.setString(3, depT);
                            ptmt.setString(4, depD);
                        }
                    } else if (depD != null) { //dep arr depD
                        ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_DEP_ARR_DATE);
                        ptmt.setString(1, dep);
                        ptmt.setString(2, arr);
                        ptmt.setString(3, depD);
                    }
                } else if (depT != null) { //dep depT
                    ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_DEP_TIME);
                    ptmt.setString(1, dep);
                    ptmt.setString(2, depT);
                    if (depD != null) { //dep depT depD
                        ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_DEP_TIME_DATE);
                        ptmt.setString(1, dep);
                        ptmt.setString(2, depT);
                        ptmt.setString(3, depD);
                    }
                } else if (depD != null){ //dep depD
                    ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_DEP_DATE);
                    ptmt.setString(1, dep);
                    ptmt.setString(2, depD);
                }
            } else  if (arr != null) { //arr
                ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_ARR);
                ptmt.setString(1, arr);
                if (depT != null) { //arr depT
                    ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_ARR_TIME);
                    ptmt.setString(1, arr);
                    ptmt.setString(2, depT);
                    if (depD != null){ //arr depT depD
                        ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_ARR_TIME_DATE);
                        ptmt.setString(1, arr);
                        ptmt.setString(2, depT);
                        ptmt.setString(3, depD);
                    }
                } else if (depD != null) { //arr depD
                    ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_ARR_DATE);
                    ptmt.setString(1, arr);
                    ptmt.setString(2, depD);
                }
            } else if (depT != null) { //depT
                ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_TIME);
                ptmt.setString(1, depT);
                if (depD != null) { //depT depD
                    ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_TIME_DATE);
                    ptmt.setString(1, depT);
                    ptmt.setString(2, depD);
                }
            } else if (depD != null){ //depD
                ptmt = conn.prepareStatement(Query.FLIGHT_SEARCH_DATE);
                ptmt.setString(1, depD);
            }

      rs1 = ptmt.executeQuery();
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
}