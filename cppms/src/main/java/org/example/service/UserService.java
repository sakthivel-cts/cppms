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

    public void addNewUser(String name, int age){
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO user(name, age) VALUES(?, ?)");
            ps.setString(1, name);
            ps.setInt(2, age);

            ps.executeUpdate();

            logger.info("User Added Successfully!!!");
        } catch (SQLException e) {
            logger.error("Error : ", e);
        }
    }

    public ResultSet getId(int id){
        PreparedStatement ps;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM user Where id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            logger.info("User Derived Successfully!!!");
        } catch (SQLException e) {
            logger.error("Error : ", e);
        }
        return rs;
    }
    public void update(String name, int ID){
        PreparedStatement ps;
        try {
            ps= connection.prepareStatement("UPDATE user SET name = ? WHERE id = ? ");
            ps.setString(1,name);
            ps.setInt(2,ID);
            ps.executeUpdate();
            logger.info("Updated Successfully!!!");
        } catch (SQLException e) {
            logger.error("Error",e);
        }
    }
    public void delete(int id){
        PreparedStatement ps;
        try {
            ps= connection.prepareStatement("DELETE FROM user WHERE id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
