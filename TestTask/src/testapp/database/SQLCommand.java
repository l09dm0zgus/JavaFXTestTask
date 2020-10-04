package testapp.database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating SQL quires.
 */
public class SQLCommand {
    private Connection connection;
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    /**
     * Using for execute INSERT, UPDATE, DELETE, CREATE TABLE, DROP TABLE sql commands.
     * @param query SQL Query.
     * @return Number of created/changed/deleted rows in database.
     * @throws SQLException
     */
    public int executeUpdate(String query) throws SQLException {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
    }

    /**
     * Using for execute SELECT sql command.
     * @param query SQL Query.
     * @param columnLabel - name of column,where get data.
     * @return Data from table.
     * @throws SQLException
     */
    public List executeQuery(String query, String columnLabel) throws  SQLException{
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        List<String> data = new ArrayList<>();
        while (result.next()){
              data.add(result.getString(columnLabel));
        }
        return data;
    }
}
