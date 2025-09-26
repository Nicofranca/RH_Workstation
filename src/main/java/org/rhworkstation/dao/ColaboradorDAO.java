package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.model.Colaborador;

import java.sql.*;

public class ColaboradorDAO {

    public void desligarColaborador(int id) throws SQLException {
        String query = "DELETE FROM colaborador WHERE id = ?";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        }
    }

}