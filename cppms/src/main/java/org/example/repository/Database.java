package org.example.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    private Database() {}

    private static Connection createConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
             logger.error("Error : ", e);
        }
        return conn;
    }

    public static Connection getConnection() {
        if (connection == null) connection = createConnection();
        return connection;
    }
}