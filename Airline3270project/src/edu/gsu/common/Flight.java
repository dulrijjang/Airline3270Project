package edu.gsu.common;

import edu.gsu.db.DBQuery;
import javafx.collections.ObservableList;

public class Flight {

    private String flightID;
    private String airline;
    private String departure;
    private String arrival;
    private String depTime;
    private String arrTime;
    private String depDate;
    private String month;
    private String day;
    private String time;
    private String action;

    public Flight(){
    }

    public Flight(String flightID, String airline, String departure, String arrival,
                  String depTime, String arrTime, String depDate) {
        this.flightID = flightID;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.depDate = depDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }


    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depHour, String depMin) {
        this.depTime = depHour + ":" + depMin;
    }

    public void setDepTime(String depHourMin) {
        this.depTime = depHourMin;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrHour, String arrMin) {
        this.arrTime = arrHour + ":" + arrMin;
    }

    public void setArrTime(String arrHourMin) {
        this.arrTime = arrHourMin;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depMo, String depDay, String depYear) {
        this.depDate = depMo + "/" + depDay + "/" + depYear;
    }

    public void setDepDate(String depMoDayYear) {
        this.depDate = depMoDayYear;
    }

}
