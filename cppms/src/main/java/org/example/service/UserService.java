package org.example.service;

import org.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final Connection connection;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(Connection connection) {
        this.connection = connection;
    }

    // I have just implemented this get users list, Try other methods.....

    public List<User> getUserList() {
        PreparedStatement ps;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);

                users.add(new User(id, name, age));
            }
        } catch (SQLException e) {
            logger.error("Error : ", e);
        }

        return users;
    }

    // TODO Complete the remaining database functions

    public User getUserWithId(int userId) {
        ResultSet rs = null;
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM user WHERE id = ?"
            );
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);

                user = new User(id, name, age);
            }
        } catch (SQLException e) {
            logger.error("Error : ", e);
        }
        return user;
    }

    public void addNewUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO user(name, age) VALUES(?, ?)"
            );

            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());

            ps.executeUpdate();
            logger.info("User Updated Successfully!!!");
        } catch (SQLException e) {
            logger.error("Error : ", e);
        }
    }

    public void deleteUserWithId(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM user WHERE id = ?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
            logger.info("User Deleted Successfully!!!");
        } catch (SQLException e) {
            logger.error("Error : ", e);
        }
    }

    public User updateUserWithId(int id, User user) {
        PreparedStatement ps = null;
        try {
            if (user.getName().trim().isEmpty()) {
                ps = connection.prepareStatement(
                        "UPDATE user SET age = ? WHERE id = ?"
                );
                ps.setInt(1, user.getAge());
                ps.setInt(2, id);
            } else if (user.getAge() == 0) {
                ps = connection.prepareStatement(
                        "UPDATE user SET name = ? WHERE id = ?"
                );
                ps.setString(1, user.getName());
                ps.setInt(2, id);
            } else {
                ps = connection.prepareStatement(
                        "UPDATE user SET name = ?, age = ? WHERE id = ?"
                );
                ps.setString(1, user.getName());
                ps.setInt(2, user.getAge());
                ps.setInt(3, user.getId());
            }
            ps.executeUpdate();
            logger.info("User Updated Successfully");
        } catch (SQLException e) {
            logger.error("Error : ", e);
        }

        return getUserWithId(id);
    }
}
