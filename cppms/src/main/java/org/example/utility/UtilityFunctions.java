package org.example.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityFunctions {

    private static final Logger logger = LoggerFactory.getLogger(UtilityFunctions.class);

    public static void displayResultSet(ResultSet rs) {

        try {
            while (rs.next()) {
                System.out.printf("%d | %s | %d\n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
            }
        } catch (SQLException e) {
            logger.error("Error : ", e);
        }
    }
}