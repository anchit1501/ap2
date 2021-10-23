package Utils;

import java.sql.*;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getDBConnection() {
        String databaseName = "trello";
        String databaseUser = "root";
        String databasePassword = "admin@123";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
}
