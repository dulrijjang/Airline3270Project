package edu.gsu.db;

public class Query {
	
	public static final String CREATE = 
			"CREATE TABLE regi (" + 
			"royaltynumber varchar(255) Not Null," + 
			"firstname varchar(255) Not Null," + 
			"lastname varchar(255) Not Null," + 
			"id varchar(255) Not Null," + 
			"psw varchar(255) Not Null," + 
			"email varchar(255) Not Null," + 
			"address varchar(255) Not Null," + 
			"zip varchar(255) Not Null," + 
			"state varchar(255) Not Null," + 
			"ssn varchar(255) Not Null," + 
			"securityq varchar(255) Not Null," + 
			"securitya varchar(255) Not Null)";
		

    public static final String LOGIN =
            "SELECT count(*) as num  "
                    + "FROM regi "
                    + "WHERE id = ? AND psw = ?";

    public static final String REGISTER =
            "INSERT INTO regi"
                    + "(royaltynumber, firstname, lastname, id, psw, " +
                    "email, address, zip, state, ssn, securityq, securitya) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String FORGOT =
            "SELECT psw " +
                    "FROM regi " +
                    "WHERE id = ? AND securityq = ? AND securitya = ?";

    public static final String FLIGHT_DEPARTURE =
            "SELECT * " +
                    "FROM flights " +
                    "WHERE departure = ?";

    public static final String FLIGHT_ARRIVAL =
            "SELECT * " +
                    "FROM flights " +
                    "WHERE arrival = ?";

    public static final String FLIGHT_MONTHS =
            "SELECT * " +
                    "FROM flights " +
                    "WHERE months = ?";

    public static final String FLIGHT_DATES =
            "SELECT * " +
                    "FROM flights " +
                    "WHERE dates = ?";

    public static final String FLIGHT_TIMES =
            "SELECT * " +
                    "FROM flights " +
                    "WHERE times = ?";

    public static final String FLIGHT_AIRLINE =
            "SELECT * " +
                    "FROM flights " +
                    "WHERE airline = ?";

    public static final String FLIGHT_FLIGHTID =
            "SELECT * " +
                    "FROM flights " +
                    "WHERE flightID = ?";

}
