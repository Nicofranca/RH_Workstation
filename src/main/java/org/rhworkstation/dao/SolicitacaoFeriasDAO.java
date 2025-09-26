package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.model.SolicitacaoFerias;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoFeriasDAO {

    public static void criarSolicitacao(SolicitacaoFerias solicitacaoFerias) throws SQLException {
        String query = "INSERT INTO solicitacao_ferias (colaborador_id, data_inicio, data_fim, status_solicitacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, solicitacaoFerias.getColaborador_id());
            stmt.setDate(2, (Date) solicitacaoFerias.getData_inicio());
            stmt.setDate(3, (Date) solicitacaoFerias.getData_fim());
            stmt.setString(4, solicitacaoFerias.getStatus_solicitacao());
            stmt.executeUpdate();
        }
    }

    public static List<SolicitacaoFerias> listarSolicitacoes() throws SQLException {
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
        }

        return lista;
    }

}