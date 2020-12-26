package edu.gsu.db;

public class Query {

    public static final String LOGIN =
            "SELECT count(*) as num  "
                    + "FROM registration "
                    + "WHERE id = ? AND psw = ?";

    public static final String REGISTER =
            "INSERT INTO registration"
                    + "(royaltynumber, firstname, lastname, id, psw, " +
                    "email, address, zip, state, ssn, securityq, securitya) VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String FORGOT =
            "SELECT psw " +
                    "FROM registration " +
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
