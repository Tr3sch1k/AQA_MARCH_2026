package org.prog.session15.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String envType = System.getProperty("env-type", "local-chrome");
        switch (envType) {
            case "jenkins-firefox", "jenkins-chrome":
                return DriverManager.getConnection(
                        "jdbc:mysql://mysql-db-1:3306/db", "root", "password");
            default:
                return DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/db", "root", "password");
        }
    }
}
