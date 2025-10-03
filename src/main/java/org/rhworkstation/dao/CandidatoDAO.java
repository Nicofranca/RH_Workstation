package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.model.Vaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDAO {

    public static List<Candidato> listarCandidatos() throws RHException {
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

        } catch (SQLException e) {
            throw new RHException("Erro ao listar candidatos", e);
        }

        return candidatos;
    }

    public void criarCandidato(Candidato candidato) throws SQLException {
        String query = "INSERT INTO candidato (nome, cpf, email, senha, id_candidato) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, candidato.getNome());
            stmt.setString(2, candidato.getCpf());
            stmt.setString(3, candidato.getEmail());
            stmt.setString(4, candidato.getSenha());
            stmt.setInt(5, candidato.getId());

            stmt.executeUpdate();

            System.out.println("Candidato criado com sucesso!");

        } catch (SQLException e) {
            throw new RHException("Erro ao criar candidato", e);
        }
    }

    public int buscarPorCPF(String CPFCandidato) throws RHException{
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

        } catch (SQLException e) {
            throw new RHException("Erro ao buscar candidato", e);
        }

        return candidatoEncontrado.getId();
    }

    public static List<Vaga> listarVagas() throws RHException {
        List<Vaga> vagas = new ArrayList<>();

        String query = "SELECT id, nome_vaga, descricao, salario_hora FROM vagas";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Vaga vaga = new Vaga();
                vaga.setId(rs.getInt("id"));
                vaga.setNomeVaga(rs.getString("nome_vaga"));
                vaga.setDescricao(rs.getString("descricao"));
                vaga.setSalarioHora(rs.getDouble("salario_hora"));
                vagas.add(vaga);
            }

        } catch (SQLException e) {
            throw new RHException("Erro ao listar vagas", e);
        }

        return vagas;
    }

    public Candidato verificacaoCandidato(String email, String senha) throws SQLException {
        String query = "SELECT id, nome, email, cpf, senha FROM candidato WHERE email = ? AND senha = ?";
        Candidato candidato = null;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    candidato = new Candidato();
                    candidato.setId(rs.getInt("id"));
                    candidato.setNome(rs.getString("nome"));
                    candidato.setEmail(rs.getString("email"));
                    candidato.setCpf(rs.getString("cpf"));
                    candidato.setSenha(rs.getString("senha"));
                }
            }
        } catch (RHException e) {
            throw new RuntimeException(e);
        }
        return candidato;
    }

}