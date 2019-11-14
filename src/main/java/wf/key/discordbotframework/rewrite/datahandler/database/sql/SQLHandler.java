package wf.key.discordbotframework.rewrite.datahandler.database.sql;

import wf.key.discordbotframework.rewrite.datahandler.filehandler.config.ConfigReader;
import wf.key.discordbotframework.rewrite.util.logs.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SQLHandler {
    private static final String PORT = ConfigReader.read("data", "config", "mysql_port");
    private static final String DBNAME = ConfigReader.read("data", "config", "mysql_database_name");
    private static final String USER = ConfigReader.read("data", "config", "mysql_user_name");
    private static final String PASSWORD = ConfigReader.read("data", "config", "mysql_password");

    private static final String DATABASE_URL = "jdbc:mysql://" + ConfigReader.read("data", "config","mysql_ip") +":" + PORT + "/" + DBNAME;
    private static Connection connection;
    private static PreparedStatement prepareStatement;

    /**
     * @return                  the connection
     */
    private static Connection connect() {
        if (connection == null) {
            System.out.println("Connecting database...");

            try {
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                System.out.println("Database connected!");
            } catch (SQLException e) {
                Logger.logger(e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }
}
