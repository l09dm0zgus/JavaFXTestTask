package testapp.database;

import java.io.*;
import java.util.Properties;

public class DatabasePropertiesFile {
    public static boolean isFileExist(){
        File f = new File("config.properties");
        return f.exists();
    }

    /**
     * Create file with database information to login
     * @param ip - Database server.
     * @param name -Name of database.
     * @param login - Login of database user.
     * @param password - Password of database user.
     */
    public static void save(String ip,String name,String login,String password){

        try (OutputStream output = new FileOutputStream("config.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("db.ip", ip);
            prop.setProperty("db.login", login);
            prop.setProperty("db.password", password);
            prop.setProperty("db.name",name);
            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    /**
     * Search value by key in properties file.
     * @param key Key to search.
     * @return Founded value;
     */
    public static String read(String key){

        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            return prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }

}
