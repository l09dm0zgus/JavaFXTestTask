package testapp.database;
import java.util.List;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for manipulating database.
 */
public class Database {
    public Database(){
        this.connection = new DatabaseConnection();
    }
    private  DatabaseConnection connection;

    /**
     * Connect to DB.
     * @param ip   Database server.
     * @param name Database name.
     * @param username Database login.
     * @param password Database password;
     */
    public void newConnection(String ip,String name,String username,String password){
        connection.setIp(ip);
        connection.setDatabaseName(name);
        connection.setDatabaseLogin(username);
        connection.setDatabasePassword(password);
        connection.connect();
    }

    /**
     * Using for execute INSERT, UPDATE, DELETE, CREATE TABLE, DROP TABLE sql commands.
     * @param query SQL Query.
     * @return Number of created/changed/deleted rows in database.
     * @throws SQLException
     */
    public int executeUpdate(String query) throws SQLException {
        SQLCommand command = new SQLCommand();
        return connection.connectUpdate(command,query);
    }
    /**
     * Using for execute SELECT sql command.
     * @param query SQL Query.
     * @return Object result with selected rows and columns.
     * @throws SQLException
     */
    public List executeQuery(String query, String columnLabel) throws SQLException{
        SQLCommand command = new SQLCommand();
        return connection.connectQuery(command,query,columnLabel);
    }
}
