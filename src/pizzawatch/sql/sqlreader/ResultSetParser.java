package pizzawatch.sql.sqlreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ResultSetParser
{
    /**
     * Takes result from our table and produces it as an table represented by:
     * (columns=attributes)ArrayList<(rows for each attr values)LinkedList0, LL1, ...>
     * see TEST
     * @param rs
     * @param attributes
     * @return
     */
    public static ArrayList<LinkedList<String>> parseResultSetIntoArray(ResultSet rs, String attributes)
    {
        String[] tableAttributes = attributes.split(";");
        ArrayList<LinkedList<String>> parsedResults = new ArrayList<>(tableAttributes.length);
        for(int i = 0; i < tableAttributes.length; i++) {
            parsedResults.add(new LinkedList<String>());
        }

        if(rs == null) {
            return parsedResults;
        }

        try {
            while(rs.next()) {
                for(int i = 0; i < tableAttributes.length; i++) {
                    parsedResults.get(i).add(rs.getString(tableAttributes[i]));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parsedResults;
    }

    private ResultSetParser() {}
}
