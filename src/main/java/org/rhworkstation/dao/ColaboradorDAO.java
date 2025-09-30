package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;

import java.sql.*;

public class ColaboradorDAO {

    public void atualizarSenha(int id, String novaSenha) throws SQLException {
        String query = "UPDATE colaborador SET senha = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, novaSenha);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void atualizarEmail(int id, String novoEmail) throws SQLException {
        String query = "UPDATE colaborador SET email = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, novoEmail);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void gerarDadosParaFolhaSalarial() throws SQLException {

    }

}