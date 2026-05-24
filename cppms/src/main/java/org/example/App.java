package org.example;

import org.example.repository.Database;
import org.example.service.UserService;
import org.example.utility.UtilityFunctions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        char res;
        Connection connection = Database.getConnection();
        UserService userService = new UserService(connection);
        ResultSet rs;
        do {
        System.out.println("-------------------");
        System.out.println("   DATABASE MENU   ");
        System.out.println("-------------------");
        System.out.println("|  1.Display All  |");
        System.out.println("|  2.Insert User  |");
        System.out.println("|  3.Display User |");
        System.out.println("|  4.Update User  |");
        System.out.println("|  5.Delete User  |");
        System.out.println("-------------------");
        System.out.print("Enter your requirement: ");
        int option = s1.nextInt();
            switch (option) {
                case 1:
                    // Use this userService object to call the methods you define in that file
                    rs = userService.getUserList();
                    UtilityFunctions.displayResultSet(rs);
                    break;

//        // TODO : write the method calls for your methods
                case 2:
                    System.out.print("Enter the name to add in the database: ");
                    String username = s.nextLine();
                    System.out.print("\nEnter the age of the user: ");
                    int age = s1.nextInt();
                    userService.addNewUser(username, age);
                    rs = userService.getUserList();
                    UtilityFunctions.displayResultSet(rs);
                    break;

                case 3:
                    System.out.println("Enter the unique id to get the username: ");
                    int id = s1.nextInt();
                    rs = userService.getId(id);
                    UtilityFunctions.displayResultSet(rs);
                    break;

                case 4:
                    System.out.println("Enter the id for Updation: ");
                    int id1 = s1.nextInt();
                    System.out.println();
                    System.out.println("Enter the name for Convertion: ");
                    String name = s.nextLine();
                    userService.update(name, id1);
                    rs = userService.getUserList();
                    UtilityFunctions.displayResultSet(rs);
                    break;

                case 5:
                    System.out.println("Enter the id to delete the data: ");
                    int id2 = s1.nextInt();
                    userService.delete(id2);
                    rs = userService.getUserList();
                    UtilityFunctions.displayResultSet(rs);
                    break;

                default:
                    System.out.println("ENTER VALID ONE");
                    break;
            }
            System.out.println("Do you wanna continue y/n ? : ");
            res=s1.next().charAt(0);
        }while(res=='y');
    }
}
