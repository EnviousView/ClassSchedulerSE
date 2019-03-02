package com.system.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author CalvinGabriel
 */
public class DBConnectionManager {
    
    private Connection connection;
    private String dbURL = "jdbc:sqlserver://localhost:1433;database=ClassScheduler;user=sa;password=admin123";
    public DBConnectionManager() throws ClassNotFoundException, SQLException
    {           
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.connection = DriverManager.getConnection(dbURL);
    }
    public Connection getConnection()
    {
        return this.connection;
    }
}
