package oraclejbdcconnection.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;

import oraclejbdcconnection.datamodels.Order;
import oraclejbdcconnection.datamodels.ResultSetParser;
import oraclejbdcconnection.sql.sqlreader.SqlRunner;

public class OrderUtils {
    private static final SqlRunner SQL_READER = SqlRunner.getInstance();
    private static final String REPLACE_CHAR = "<*>";

    /**
     * Add an order to the PizzaOrder table
     *
     * @param order
     */
    public static void addOrder(Order order) {
        String query = "INSERT INTO PizzaOrder VALUES <*>";
        query = query.replace(REPLACE_CHAR, "('" + order.getOrderID() + "', '" + order.getDeliveryMethod() + "', '" +
                order.getPizzaType() + "', '" + order.getIsDelivered() + "', '" + order.getIsCancellationRequested() + "', '" +
                order.getUserID() + "', '" + order.getAddress() + "')");
        SQL_READER.run(query);
    }

    public static ArrayList<LinkedList<String>> getPizzaTypeInfo() {
        final String QUERY_STRING = "SELECT * FROM Pizza";
        final String ATTRIBUTES_STRING = "pizzaType;price";

        return ResultSetParser.parseResultSetIntoArray(SQL_READER.query(QUERY_STRING), ATTRIBUTES_STRING);
    }

    public static String[] getAttributesFromPizzaTypeInfo(ArrayList<LinkedList<String>> attributesList, int index, String fallbackString) {
        if (attributesList.get(index).isEmpty()) {
            return new String[]{fallbackString};
        }

        return attributesList.get(index).toArray(new String[5]); //The number of pizza types currently in dataInserts.sql
    }

    public static DefaultComboBoxModel<String> getPizzaTypesComboBoxModel(String[] pizzaTypes) {
        return new DefaultComboBoxModel<>(pizzaTypes); //The number of pizza types currently in dataInserts.sql
    }

    private OrderUtils() {
    }
}
