package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.model.enums.StatusVaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VagaDAO {

    public List<Vaga> listarVagas() throws RHException {
        List<Vaga> vagasDisponiveis = new ArrayList<>();
        String sql = "SELECT * FROM vagas";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nomeVaga = rs.getString("nomeVaga");
                String descricao = rs.getString("descricao");
                double salarioHora = rs.getDouble("salarioHora");
                StatusVaga status = StatusVaga.valueOf(rs.getString("status"));

                Vaga vaga = new Vaga(nomeVaga, descricao, salarioHora);
                vagasDisponiveis.add(vaga);
            }

        } catch (SQLException e) {
            throw new RHException("Erro ao listar vagas", e);
        }

        return vagasDisponiveis;
    }

    public static void criarVaga(Vaga vaga) throws RHException {
        String query = "INSERT INTO vagas(nome_vaga, descricao, salario_hora) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, vaga.getNomeVaga());
            stmt.setString(2, vaga.getDescricao());
            stmt.setDouble(3, vaga.getSalarioHora());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao criar vaga", e);
        }
    }

    public static void excluirVaga(int id) throws RHException {
        String query = "DELETE FROM vagas WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao excluir vaga", e);
        }
    }

    public static void editarVaga(Vaga vaga) throws RHException {
        String query = "UPDATE vagas SET nome_vaga = ?, descricao = ?, salario_hora = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, vaga.getNomeVaga());
            stmt.setString(2, vaga.getDescricao());
            stmt.setDouble(3, vaga.getSalarioHora());
            stmt.setInt(4, vaga.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao editar vaga", e);
        }
    }

}