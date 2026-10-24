package org.a1aska17.db;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class DatabaseConfig {
    public static Connection getConnection() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user= dotenv.get("USER");
        String password= dotenv.get("PASSWORD");
        return DriverManager.getConnection(url, user, password);
    }
}
