package org.example;

import org.example.repository.Database;
import org.example.service.UserService;
import org.example.utility.UtilityFunctions;

import java.sql.Connection;
import java.sql.ResultSet;

/*

    TODO README
    This program requires you to create a database named `test`, in that create
    a table named as `user`.

    TABLE SCHEMA :
    create table user (
        id int PRIMARY KEY auto_increment,
        name varchar(50),
        age int
    );

    SAMPLE DATA :
    insert into user(name, age) values('rahul', 40),('tiwari', 40);

    After completing these steps, continue with your coding.
    This is just a sample code to implement the database queries

    /repository
    | -> Database.java
    | -> -> getConnect(); -> Method to get connection for the database

    /service
    | -> UserService.java -> Implement your methods here in this file

    /utility
    | -> UtilityFunctions.java
    | -> -> displayResultSet(); -> Used to print the ResultSet type, Use this method
                                    if it is necessary.

     This is the main file to execute all the methods. For
*/

public class App {

    public static void main( String[] args ) {
        Connection connection = Database.getConnection();

        // Use this userService object to call the methods you define in that file
        UserService userService = new UserService(connection);
        ResultSet rs = userService.getUserList();
        UtilityFunctions.displayResultSet(rs);

        // TODO : write the method calls for your methods

    }
}
