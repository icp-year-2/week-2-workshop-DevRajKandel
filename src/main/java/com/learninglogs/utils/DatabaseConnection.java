package com.learninglogs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ╔══════════════════════════════════════════════════════╗
 * ║       Database Connection Utility                    ║
 * ║                                                      ║
 * ║   This file is PROVIDED. No changes needed!          ║
 * ║   You completed this in the tutorial — study it.     ║
 * ╚══════════════════════════════════════════════════════╝
 *
 * This utility class manages the connection to your MySQL database.
 *
 * Pattern used by every DAO method:
 *   Connection conn = null;
 *   try {
 *       conn = DatabaseConnection.getConnection();
 *       // ... database work ...
 *   } catch (SQLException e) {
 *       // handle error
 *   } finally {
 *       DatabaseConnection.closeConnection(conn);
 *   }
 *
 * XAMPP Default Credentials:
 *   - URL:      jdbc:mysql://localhost:3306/learning_logs
 *   - Username: root
 *   - Password: (empty — no password by default in XAMPP)
 */
public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/learning_logs";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    /**
     * Creates and returns a new database connection.
     *
     * @return a Connection to the learning_logs database
     * @throws SQLException if the database is unreachable or credentials are wrong
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    /**
     * Safely closes a database connection.
     * Always call this in a finally block to prevent connection leaks.
     *
     * @param connection the Connection to close (can be null)
     */
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }

    }
}
