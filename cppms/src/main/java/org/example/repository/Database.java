
package org.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/test"; // my DB name
        String username = "root";
        String password = "root"; // change this

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected sucessfully");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
