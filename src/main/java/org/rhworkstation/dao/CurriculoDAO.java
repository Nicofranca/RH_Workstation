package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.model.Curriculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CurriculoDAO {
    public void criarCurriculo(Curriculo curriculo) throws SQLException{
        String query = "INSERT INTO curriculo (idade, sexo, formacao, texto, id_candidato) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, curriculo.getIdade());
            stmt.setString(2, curriculo.getSexo());
            stmt.setString(3, curriculo.getFormacao());
            stmt.setString(4, curriculo.getTexto());
            stmt.setObject(5, curriculo.getId_candidato().getId());
            stmt.executeUpdate();

            System.out.println("Curriculo Criado!");
        }
    }

    public void exluirCurriculo(int id) throws SQLException{
        String query = "DELETE FROM curriculo WHERE id_candidato = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Curriculo excluido com sucesso!");
        }
    }
}
