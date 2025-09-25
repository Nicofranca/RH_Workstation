package org.rhworkstation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://root:ZyYLbrJapvRAhZGPpzJkSzkDhofQomoQ@maglev.proxy.rlwy.net:26517/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "ZyYLbrJapvRAhZGPpzJkSzkDhofQomoQ";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

//mysql://root:ZyYLbrJapvRAhZGPpzJkSzkDhofQomoQ@maglev.proxy.rlwy.net:26517/railway
