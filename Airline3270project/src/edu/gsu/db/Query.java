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

	public static final String ROYALTY_NUM =
			"SELECT royaltynumber "
					+ "FROM regi "
					+ "WHERE id = ?";

	public static final String FIRST_NAME =
			"SELECT firstname "
					+ "FROM regi "
					+ "WHERE id = ?";

	public static final String LAST_NAME =
			"SELECT lastname "
					+ "FROM regi "
					+ "WHERE id = ?";

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

	public static final String QUESTION =
			"SELECT securityq " +
					"FROM regi " +
					"WHERE id = ?";

	public static final String MY_FLIGHTS =
			"SELECT flights.flightID, airline, depart, arrive, depTime, arrTime, depDate " +
					"FROM flights JOIN tickets ON tickets.flightID = flights.flightID " +
					"WHERE royaltynumber IN (?)";

	public static final String DELETE_FLIGHT =
			"DELETE FROM tickets " +
					"WHERE (royaltynumber = ? AND flightID = ?)";

	public static final String SAFE_UPDATE_0 =
			"SET SQL_SAFE_UPDATES = 0";

	public static final String SAFE_UPDATE_1 =
			"SET SQL_SAFE_UPDATES = 1";

	public static final String FLIGHT_SEARCH =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND arrive = ? AND depTime = ? AND depDate = ?)";

	/**
	 * 	public static final String FLIGHT_SEARCH =
	 *             "SELECT * " +
	 *                     "FROM flights " +
	 *                     "WHERE (airline = ? AND depart = ? AND arrive = ? AND depTime = ? AND depDate = ?)";
	 *
	 */ public static final String FLIGHT_SEARCH_AIR =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ?)";

	public static final String FLIGHT_SEARCH_AIR_DEP =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ?)";

	public static final String FLIGHT_SEARCH_AIR_DEP_ARR =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND arrive = ?)";

	public static final String FLIGHT_SEARCH_AIR_DEP_ARR_TIME =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND arrive = ? AND depTime = ?)";

	public static final String FLIGHT_SEARCH_AIR_DEP_ARR_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND arrive = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_AIR_DEP_TIME =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND depTime = ?)";

	public static final String FLIGHT_SEARCH_AIR_DEP_TIME_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND depTime = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_AIR_DEP_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_AIR_ARR =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND arrive = ?)";

	public static final String FLIGHT_SEARCH_AIR_ARR_TIME =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND arrive = ? AND depTime = ?)";

	public static final String FLIGHT_SEARCH_AIR_ARR_TIME_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND arrive = ? AND depTime = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_AIR_ARR_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND arrive = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_AIR_TIME =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depTime = ?)";

	public static final String FLIGHT_SEARCH_AIR_TIME_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depTime = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_AIR_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_DEP =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ?)";

	public static final String FLIGHT_SEARCH_DEP_ARR =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND arrive = ?)";

	public static final String FLIGHT_SEARCH_DEP_ARR_TIME =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND arrive = ? AND depTime = ?)";

	public static final String FLIGHT_SEARCH_DEP_ARR_TIME_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND arrive = ? AND depTime = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_DEP_ARR_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND arrive = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_DEP_TIME =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND depTime = ?)";

	public static final String FLIGHT_SEARCH_DEP_TIME_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND depTime = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_DEP_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_ARR =
			"SELECT * " +
					"FROM flights " +
					"WHERE (arrive = ?)";

	public static final String FLIGHT_SEARCH_ARR_TIME =
			"SELECT * " +
					"FROM flights " +
					"WHERE (arrive = ? AND depTime = ?)";

	public static final String FLIGHT_SEARCH_ARR_TIME_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (arrive = ? AND depTime = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_ARR_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (arrive = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_TIME =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depTime = ?)";

	public static final String FLIGHT_SEARCH_TIME_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depTime = ? AND depDate = ?)";

	public static final String FLIGHT_SEARCH_DATE =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depDate = ?)";

	public static final String FLIGHT_SEARCH_NULL =
			"SELECT * FROM flights";

	public static final String ALL_FLIGHTS =
			"SELECT * " +
					"FROM flights ";

	public static final String BOOK_FLIGHT =
			"INSERT INTO tickets "
					+ "(royaltynumber, flightID) VALUES"
					+ "(?, ?)";

}
