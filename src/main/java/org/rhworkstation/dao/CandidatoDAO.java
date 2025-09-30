package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.model.Candidato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public int buscarPorCPF(String CPFCandidato) throws SQLException{
        String query = "SELECT id FROM candidato WHERE cpf = (?)";

        Candidato candidatoEncontrado = null;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, CPFCandidato);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    candidatoEncontrado = new Candidato();

                    candidatoEncontrado.setId(rs.getInt("id"));
                }
            }
        }

        return candidatoEncontrado.getId();
    }
}


//Olhar Minhas vagas