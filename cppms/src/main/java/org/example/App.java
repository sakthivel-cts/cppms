package org.example;

import java.sql.Connection;

import org.example.model.User;
import org.example.repository.Database;
import org.example.service.UserService;

public class App {
    public static void main(String[] args) {

        Connection connection = Database.getConnection();
        UserService service = new UserService(connection);

        // CREATE
        service.createUser(new User(0, "Nigashini", 25));

        // READ
        User user = service.getUser(1);
        System.out.println(user.getName());

        // UPDATE
        service.updateUser(1, new User(0, "Dharshana", 30));

        // DELETE
        service.deleteUser(1);
    }
}