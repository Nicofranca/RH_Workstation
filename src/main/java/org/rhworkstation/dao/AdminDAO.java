package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.model.Colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public void criarColaborador(Colaborador colaborador) throws SQLException {
        String query = "INSERT INTO colaborador(nome, cpf, email, cargo, departamento, salario_hora, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getCpf());
            stmt.setString(3, colaborador.getEmail());
            stmt.setString(4, colaborador.getCargo());
            stmt.setString(5, colaborador.getDepartamento());
            stmt.setDouble(6, colaborador.getSalario_hora());
            stmt.setString(7, colaborador.getSenha());
            stmt.executeUpdate();

        }
    }

    public static void editarColaborador(Colaborador colaborador) throws SQLException {
        String query = "UPDATE colaborador SET nome = ?, cpf = ?, email = ?, cargo = ?, departamento = ?, salario_hora = ?, senha = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getCpf());
            stmt.setString(3, colaborador.getEmail());
            stmt.setString(4, colaborador.getCargo());
            stmt.setString(5, colaborador.getDepartamento());
            stmt.setDouble(6, colaborador.getSalario_hora());
            stmt.setString(7, colaborador.getSenha());
            stmt.setInt(8, colaborador.getId());
            stmt.executeUpdate();
        }
    }

    public void desligarColaborador(int id) throws SQLException {
        String query = "DELETE FROM colaborador WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        }
    }

    public static List<Candidato> listarCandidatos() throws SQLException {
        List<Candidato> candidatos = new ArrayList<>();

        String query = "SELECT id, nome, cpf, email FROM candidato";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Candidato candidato = new Candidato();
                candidato.setId(rs.getInt("id"));
                candidato.setNome(rs.getString("nome"));
                candidato.setCpf(rs.getString("cpf"));
                candidato.setEmail(rs.getString("email"));
                candidatos.add(candidato);
            }
        }

        return candidatos;
    }

}