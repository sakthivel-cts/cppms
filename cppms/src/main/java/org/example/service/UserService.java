package org.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.model.User;

public class UserService {

    private Connection connection; // Declare connection

    //Constructor to receive connection
    public UserService(Connection connection) {
        this.connection = connection;
    }

    public void createUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO user(name, age) VALUES(?, ?)"
            );
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.executeUpdate();
            System.out.println("User created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM user WHERE id = ?"
            );
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(int id, User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE user SET name = ?, age = ? WHERE id = ?"
            );

            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setInt(3, id);

            ps.executeUpdate();
            System.out.println("User updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM user WHERE id = ?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("User deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}