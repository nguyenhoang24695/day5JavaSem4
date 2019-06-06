package com.fpt.edu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  ConnectionHelper  {
    // Singleton instance
    protected static ConnectionHelper _instance;
    public static ConnectionHelper getInstance() {
        if (_instance == null) {
            _instance = new ConnectionHelper();
        }
        return _instance;
    }


    protected  Connection ConnectionHelper() throws SQLException {
        Connection  connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sem4studentjava?useUnicode=true&characterEncoding=utf-8", "root", "");
        return connection;
    }
}
