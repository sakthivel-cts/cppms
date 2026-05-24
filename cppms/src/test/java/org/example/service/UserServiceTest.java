package org.example.service;

import org.example.repository.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

//    @BeforeEach
//    void setup() {
//
//    }

    Connection connection = Database.getConnection();
    UserService userService = new UserService(connection);

    @Test
    void testGetId() {
        ResultSet rs = userService.getId(1);
        String name = null;
        int age = 0;

        try {
            while (rs.next()) {
                name = rs.getString(2);
                age = rs.getInt(3);
            }
        } catch (SQLException e) {
            logger.error("Error in Test : ", e);
        }

        assertEquals("shailesh", name);
        assertEquals(21, age);
    }
}
