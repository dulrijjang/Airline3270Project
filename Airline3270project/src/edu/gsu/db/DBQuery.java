package edu.gsu.db;

import java.sql.*;

import edu.gsu.common.*;
import edu.gsu.common.Action;
import edu.gsu.exceptions.*;
import edu.gsu.exceptions.LoginException;
import edu.gsu.GUI.*;



import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.db.Query;


public class DBQuery{
	
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/?user=root?iseTimezone=true&serverTimezone=UTC";
    private static String USN = "root";
    private static String PSW = "Xkwhdkf1@";

    public static void login(Customer c1) throws Exception {

        Connection conn = null;

        try {

            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USN,PSW);
            System.out.println("Connected");

            // Create a statement
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

        }
        finally {

            conn.close();
        }
    }

    public static void getFlights(Customer customer) throws Exception {

        // can I run a query on reservation table that select all teh rows with customerID comes from co

        Flight f1 = new Flight();
        f1.setAirline("a");

        Flight f2 = new Flight();
        f2.setAirline("b");

        Flight f3 = new Flight();
        f3.setAirline("c");

        customer.getFlights().add(f1);
        customer.getFlights().add(f2);
        customer.getFlights().add(f3);

    }

    public static void register(Customer c1) throws Exception {


        Connection conn = null;

        try {

            Class.forName(DRIVER);
            System.out.println("driver found");

            conn = DriverManager.getConnection(URL,USN,PSW);
            System.out.println("Connected");


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


        }
        catch (Exception e){
            System.out.print(e);
        }
        finally {
            conn.close();
        }

    }

    public static void forgot(Customer c1) throws Exception {

        Connection conn = null;

        try {

            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USN,PSW);
            System.out.println("Connected");

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Query.FORGOT);

            ptmt.setString(1, c1.getLoginID());
            ptmt.setString(2, c1.getSecurityQ());
            ptmt.setString(3, c1.getSecurityA());

            // Execute a statement
            ResultSet rs1 = ptmt.executeQuery();

            String psw;

            // Iterate through the result and print the student names
            while (rs1.next()) {
                psw = rs1.getNString(1);
                System.out.print(psw);
            }


        } catch (SQLException e) {

            System.out.println(e);
            throw e;
        }
        finally {

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