package testapp.database;
import java.sql.*;
import java.util.List;

/**
 * Class for connection to database
 */
public class DatabaseConnection {
    private String ip = "";
    private String databaseName = "";
    private String databasePassword = "";
    private String databaseLogin = "";
    private String url;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void setDatabaseLogin(String databaseLogin) {
        this.databaseLogin = databaseLogin;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }


    private void checkEmptyString(String s,String message){
        if(s.isEmpty()){
            throw new RuntimeException(message);
        }
    }

    /**
     * Check if entered server ip,database name,database password and login.
     */
    private void checkValidDBProperties(){
        checkEmptyString(ip,"ERROR::Please set ip!");
        checkEmptyString(databaseName,"ERROR::Please set DB name!");
        checkEmptyString(databasePassword,"ERROR::Please set DB password!");
        checkEmptyString(databaseLogin,"ERROR::Please set DB login!");
    }

    /**
     * Just connect to database.
     */
    public void connect(){
        checkValidDBProperties();
        url = "jdbc:mysql://"+ip+"/"+databaseName+"?serverTimezone=Europe/Moscow&useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection connection = DriverManager.getConnection(url,databaseLogin,databasePassword)) {
                System.out.println("Connection to "+databaseName+" DB successful!");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    /**
     * Connecting to Database and executing query.
     * Using for query with INSERT, UPDATE, DELETE, CREATE TABLE, DROP TABLE  command.
     * @param command  object of class SQLCommand
     * @param query - query.
     * @return  0 if query failed.Number of created or deleted rows if query successful;
     */
    public int connectUpdate(SQLCommand command,String query){
        checkValidDBProperties();
        url = "jdbc:mysql://"+ip+"/"+databaseName+"?serverTimezone=Europe/Moscow&useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection connection = DriverManager.getConnection(url,databaseLogin,databasePassword)) {
                command.setConnection(connection);
                return command.executeUpdate(query);
            }

        }
        catch(Exception ex){
            System.out.println("Query failed...");
            System.out.println(ex);
            return 0;
        }
    }

    /**
     * Connecting to Database and executing query.
     * Using for query with SELECT command.
     * @param command  object of class SQLCommand
     * @param query - query.
     * @return  List with selected column.
     */
    public List connectQuery(SQLCommand command, String query, String columnLabel){
        checkValidDBProperties();
        url = "jdbc:mysql://"+ip+"/"+databaseName+"?serverTimezone=Europe/Moscow&useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection connection = DriverManager.getConnection(url,databaseLogin,databasePassword)) {
                command.setConnection(connection);
                return command.executeQuery(query,columnLabel);
            }

        }
        catch(Exception ex){
            System.out.println("Query failed...");
            System.out.println(ex);
            return null;
        }
    }
}
