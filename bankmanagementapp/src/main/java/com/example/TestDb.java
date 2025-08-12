package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDb {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankms", "root", "SahilGupta");
            System.out.println("✅ Connected to database");
        } catch (Exception e) {
            System.out.println("❌ Connection failed: " + e);
        }
    }
}
