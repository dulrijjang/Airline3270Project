package edu.gsu.bizlogic;

import edu.gsu.common.Flight;
import edu.gsu.db.DBQuery;
import edu.gsu.common.Action;
import edu.gsu.common.Customer;

public class BizLogicProcess {

    public static void process1(Customer c1) throws Exception {

        switch (c1.getAction()) {

            case Action.LOGIN:

                DBQuery.login(c1);
                break;

            case Action.GET_FLIGHTS:

                DBQuery.getFlights(c1);
                break;

            case Action.REGISTER:

                DBQuery.register(c1);
                break;

            case Action.FORGOT:

                DBQuery.forgot(c1);
                break;



        }

    }

    public static void process2(Flight f1) throws Exception {

        DBQuery.search(f1);

    }

}
