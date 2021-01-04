package edu.gsu.GUI;

import edu.gsu.bizlogic.BizLogicProcess;
import edu.gsu.common.Flight;
import edu.gsu.exceptions.LoginException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
//book a new flight
public class BookingPanel extends JPanel {

    private Flight f1 = new Flight();
    private int criterion = 0;

    private JButton search;
    private JLabel criteria;
    private JButton departure;
    private JComboBox<String> depChoice;
    private JButton arrival;
    private JComboBox<String> arrChoice;
    private JButton month;
    private JComboBox<String> moChoice;
    private JButton day;
    private JComboBox<String> dayChoice;
    private JButton time;
    private JComboBox<String> timeChoice;
    private JButton airline;
    private JComboBox<String> airChoice;

    public BookingPanel(){

        setPreferredSize(new Dimension(300, 350));
        setBackground(Color.WHITE);
        setLayout(null);

        criteria = new JLabel("Search flights by one of the following: ");
        criteria.setBounds(20, 25, 300, 35);
        add(criteria);

        departure = new JButton("Departure: ");
        departure.addActionListener(new BookingPanel.ButtonListener());
        departure.setBounds(20, 75, 100, 25);
        add(departure);

        String[] departures = {"ATL", "NYC", "LAX", "SFO", "ORD"};
        depChoice = new JComboBox<String>(departures);
        depChoice.setBounds(125, 75, 150, 25);
        add(depChoice);
        depChoice.setVisible(false);

        arrival = new JButton("Arrival: ");
        arrival.addActionListener(new BookingPanel.ButtonListener());
        arrival.setBounds(20, 105, 100, 25);
        add(arrival);

        String[] arrivals = {"ATL", "NYC", "LAX", "SFO", "ORD"};
        arrChoice = new JComboBox<String>(arrivals);
        arrChoice.setBounds(125, 105, 150, 25);
        add(arrChoice);
        arrChoice.setVisible(false);

        month = new JButton("Month: ");
        month.addActionListener(new BookingPanel.ButtonListener());
        month.setBounds(20, 135, 100, 25);
        add(month);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        moChoice = new JComboBox<String>(months);
        moChoice.setBounds(125, 135, 150, 25);
        add(moChoice);
        moChoice.setVisible(false);

        day = new JButton("Date: ");
        day.addActionListener(new BookingPanel.ButtonListener());
        day.setBounds(20, 165, 100, 25);
        add(day);

        String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        dayChoice = new JComboBox<String>(days);
        dayChoice.setBounds(125, 165, 150, 25);
        add(dayChoice);
        dayChoice.setVisible(false);

        time = new JButton("Time: ");
        time.addActionListener(new BookingPanel.ButtonListener());
        time.setBounds(20, 195, 100, 25);
        add(time);

        String[] times = {"1", "2", "3", "6", "7", "10", "11", "14", "15", "18"};
        timeChoice = new JComboBox<String>(times);
        timeChoice.setBounds(125, 195, 150, 25);
        add(timeChoice);
        timeChoice.setVisible(false);

        airline = new JButton("Airline: ");
        airline.addActionListener(new BookingPanel.ButtonListener());
        airline.setBounds(20, 225, 100, 25);
        add(airline);

        String[] airlines = {"Delta", "EVA", "United", "American"};
        airChoice = new JComboBox<String>(airlines);
        airChoice.setBounds(125, 225, 150, 25);
        add(airChoice);
        airChoice.setVisible(false);

        search = new JButton("Search Flights");
        search.addActionListener(new BookingPanel.SearchButtonListener());
        search.setBounds(75,285,150,30);
        add(search);

    }
    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            if(event.getSource() == departure) {
                depChoice.setVisible(true);
                arrChoice.setVisible(false);
                moChoice.setVisible(false);
                dayChoice.setVisible(false);
                timeChoice.setVisible(false);
                airChoice.setVisible(false);

                criterion = 1;

            } else if (event.getSource() == arrival) {
                depChoice.setVisible(false);
                arrChoice.setVisible(true);
                moChoice.setVisible(false);
                dayChoice.setVisible(false);
                timeChoice.setVisible(false);
                airChoice.setVisible(false);

                criterion = 2;

            } else if (event.getSource() == month) {
                depChoice.setVisible(false);
                arrChoice.setVisible(false);
                moChoice.setVisible(true);
                dayChoice.setVisible(false);
                timeChoice.setVisible(false);
                airChoice.setVisible(false);

                criterion = 3;

            } else if (event.getSource() == day) {
                depChoice.setVisible(false);
                arrChoice.setVisible(false);
                moChoice.setVisible(false);
                dayChoice.setVisible(true);
                timeChoice.setVisible(false);
                airChoice.setVisible(false);

                criterion = 4;

            } else if (event.getSource() == time) {
                depChoice.setVisible(false);
                arrChoice.setVisible(false);
                moChoice.setVisible(false);
                dayChoice.setVisible(false);
                timeChoice.setVisible(true);
                airChoice.setVisible(false);

                criterion = 5;

            } else if (event.getSource() == airline) {
                depChoice.setVisible(false);
                arrChoice.setVisible(false);
                moChoice.setVisible(false);
                dayChoice.setVisible(false);
                timeChoice.setVisible(false);
                airChoice.setVisible(true);

                criterion = 6;

            }

        }
    }
    class SearchButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            switch (criterion) {
                case 1:
                    String dep = depChoice.getSelectedItem() + "";
                    f1.setDeparture(dep);
                    f1.setAction("flightDep");

                    try {
                        BizLogicProcess.process2(f1);
                    } catch (Exception e) {
                        System.out.print(e);
                    }

                    break;

                case 2:
                    String arr = arrChoice.getSelectedItem() + "";
                    f1.setArrival(arr);
                    f1.setAction("flightArrival");

                    try {
                        BizLogicProcess.process2(f1);
                    } catch (Exception e) {
                        System.out.print(e);
                    }

                    break;

                case 3:
                    String mo1 = moChoice.getSelectedItem() + "";
                    String mo = null;

                    switch (mo1) {
                        case "Jan":
                            mo = 1 + "";
                            break;

                        case "Feb":
                            mo = 2 + "";
                            break;

                        case "Mar":
                            mo = 3 + "";
                            break;

                        case "Apr":
                            mo = 4 + "";
                            break;

                        case "May":
                            mo = 5 + "";
                            break;

                        case "Jun":
                            mo = 6 + "";
                            break;

                        case "Jul":
                            mo = 7 + "";
                            break;

                        case "Aug":
                            mo = 8 + "";
                            break;

                        case "Sep":
                            mo = 9 + "";
                            break;

                        case "Oct":
                            mo = 10 + "";
                            break;

                        case "Nov":
                            mo = 11 + "";
                            break;

                        case "Dec":
                            mo = 12 + "";
                            break;
                    }

                    f1.setMonth(mo);
                    f1.setAction("flightMo");

                    try {
                        BizLogicProcess.process2(f1);
                    } catch (Exception e) {
                        System.out.print(e);
                    }

                    break;

                case 4:
                    String day = dayChoice.getSelectedItem() + "";
                    f1.setDay(day);
                    f1.setAction("flightDay");

                    try {
                        BizLogicProcess.process2(f1);
                    } catch (Exception e) {
                        System.out.print(e);
                    }

                    break;

                case 5:
                    String ti = timeChoice.getSelectedItem() + "";
                    f1.setTime(ti);
                    f1.setAction("flightTime");

                    try {
                        BizLogicProcess.process2(f1);
                    } catch (Exception e) {
                        System.out.print(e);
                    }

                    break;

                case 6:
                    String air = airChoice.getSelectedItem() + "";
                    f1.setAirline(air);
                    f1.setAction("flightAir");

                    try {
                        BizLogicProcess.process2(f1);
                    } catch (Exception e) {
                        System.out.print(e);
                    }

                    break;
            }

        }
    }
}
*/