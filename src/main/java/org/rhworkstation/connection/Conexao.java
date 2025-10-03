package org.rhworkstation.connection;

import org.rhworkstation.exception.RHException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://root:ZyYLbrJapvRAhZGPpzJkSzkDhofQomoQ@maglev.proxy.rlwy.net:26517/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "ZyYLbrJapvRAhZGPpzJkSzkDhofQomoQ";

    public static Connection conectar() throws RHException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RHException("Erro ao conectar com o banco de dados", e);
        }
    }

}

//mysql://root:ZyYLbrJapvRAhZGPpzJkSzkDhofQomoQ@maglev.proxy.rlwy.net:26517/railway