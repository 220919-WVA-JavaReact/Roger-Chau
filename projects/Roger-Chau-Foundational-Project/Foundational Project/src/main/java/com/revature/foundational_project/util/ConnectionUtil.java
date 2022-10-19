package com.revature.foundational_project.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static Connection conn = null;

    private ConnectionUtil(){

    }

    public static Connection getConnection(){
        try{
            if (conn != null && !conn.isClosed()){
                System.out.println("Use a previously made connection");
                return conn;
            }
        } catch (SQLException e){
            System.out.println("Could not establish a connection to the database!");
            return null;
        }

        String url = "";
        String username = "";
        String password = "";

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/resources/application.properties"));
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Established Connection to Database!");
        } catch (IOException e) {
            System.out.println("Property file not found!");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Could not establish connection!");
            throw new RuntimeException(e);
        }
        return conn;
    }

    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load PostgreSQL driver");
            throw new RuntimeException(e);
        }
    }
}
