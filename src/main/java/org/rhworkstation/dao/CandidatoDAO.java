package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.model.Candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidatoDAO {
    public void criarCandidato(Candidato candidato) throws SQLException {
        String query = "INSERT INTO candidato (nome, cpf, email, senha) VALUES (?, ?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, candidato.getNome());
            stmt.setString(2, candidato.getCpf());
            stmt.setString(3, candidato.getEmail());
            stmt.setString(4, candidato.getSenha());

            stmt.executeUpdate();

            System.out.println("Candidato criado com sucesso!");
        }
    }
}


//Olhar Minhas vagas