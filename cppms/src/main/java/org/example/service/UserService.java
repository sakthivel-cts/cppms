package org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    private final Connection connection;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(Connection connection) {
        this.connection = connection;
    }

    // I have just implemented this get users list, Try other methods.....

    public ResultSet getUserList() {
        PreparedStatement ps;
        ResultSet rs = null;
        String query = "SELECT * FROM user";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            logger.error("Error : ", e);
        }

        return rs;
    }

    // TODO Complete the remaining database functions
}
