package edu.gsu.common;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Customer {

    private String royaltyNumber;
    private String firstName;
    private String lastName;
    private String loginID;
    private String password;
    private String email;
    private String address;
    private String zip;
    private String state;
    private String ssn;
    private String securityQ;
    private String securityA;
    private ObservableList<Flight> flights;
    private String action;

    public Customer() {
    }

    public String getRoyaltyNumber() {
        return royaltyNumber;
    }

    public void setRoyaltyNumber(String royaltyNumber) {
        this.royaltyNumber = royaltyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSSN() {
        return ssn;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

    public String getSecurityQ() {
        return securityQ;
    }

    public void setSecurityQ(String securityQ) {
        this.securityQ = securityQ;
    }

    public String getSecurityA() {
        return securityA;
    }

    public void setSecurityA(String securityQ) {
        this.securityA = securityQ;
    }

    public ObservableList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ObservableList<Flight> flights) {
        this.flights = flights;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}