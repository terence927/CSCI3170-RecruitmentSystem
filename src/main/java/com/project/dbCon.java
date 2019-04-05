package com.project;

import java.sql.*;

public class dbCon {
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String dbAddr = "jdbc:mysql://projgw.cse.cuhk.edu.hk:2633/Rdb8";
    private static String User = "Random8";
    private static String pw = "CSCI3170";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
            	con = DriverManager.getConnection(dbAddr,User,pw);
            } catch (SQLException ex) {
                System.out.println("Failed to connect to database.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found."); 
        }
        return con;
    }
}