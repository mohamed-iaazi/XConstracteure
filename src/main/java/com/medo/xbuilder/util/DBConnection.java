package com.medo.xbuilder.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private  final String URL = "jdbc:mysql://localhost:3306/Xconstracteur";
    private  final String USER = "root";
    private  final String PASSWORD = "root";
    private  Connection connection;

        public  Connection getConnection() {



                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Database connection failed!");
                }

            return connection;
        }



}
