package org.rhworkstation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "mysql://root:ZyYLbrJapvRAhZGPpzJkSzkDhofQomoQ@maglev.proxy.rlwy.net:26517/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "ZyYLbrJapvRAhZGPpzJkSzkDhofQomoQ@maglev";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


