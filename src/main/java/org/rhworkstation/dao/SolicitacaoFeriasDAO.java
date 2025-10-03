package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.SolicitacaoFerias;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoFeriasDAO {

    public static void criarSolicitacao(SolicitacaoFerias solicitacaoFerias) throws RHException {
        String query = "INSERT INTO solicitacao_ferias (colaborador_id, data_inicio, data_fim, status_solicitacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, solicitacaoFerias.getColaborador_id());
            stmt.setDate(2, (Date) solicitacaoFerias.getData_inicio());
            stmt.setDate(3, (Date) solicitacaoFerias.getData_fim());
            stmt.setString(4, solicitacaoFerias.getStatus_solicitacao());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao criar solicitação", e);
        }
    }

    public static List<SolicitacaoFerias> listarSolicitacoes() throws RHException {
        List<SolicitacaoFerias> lista = new ArrayList<>();
        String query = "SELECT * FROM solicitacao_ferias";

        try (Connection conn = Conexao.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                SolicitacaoFerias solicitacaoFerias = new SolicitacaoFerias(
                        rs.getInt("id"),
                        rs.getInt("colaborador_id"),
                        rs.getDate("data_inicio"),
                        rs.getDate("data_fim"),
                        rs.getString("status_solicitacao")
                );

                lista.add(solicitacaoFerias);
            }

        } catch (SQLException e) {
            throw new RHException("Erro ao listar solicitação", e);
        }

        return lista;
    }

    public static void atualizarStatusSolicitacao(int id, String status) throws RHException {
        String query = "UPDATE solicitacao_ferias SET status_solicitacao = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao atualizar status da solicitação", e);
        }
    }

    public static void deletarSolicitacao(int id) throws RHException {
        String query = "DELETE FROM solicitacao_ferias WHERE id = ?";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao deletar solicitação", e);
        }
    }

}