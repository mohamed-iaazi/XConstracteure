package com.medo.xbuilder.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/Xconstracteur";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;

        public static Connection getConnection() {



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
