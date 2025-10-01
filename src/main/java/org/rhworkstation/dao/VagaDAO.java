package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.model.enums.StatusVaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VagaDAO {


    public List<Vaga> listarVagas() {
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
            System.out.println("Erro ao listar vagas disponíveis: " + e.getMessage());
        }

        return vagasDisponiveis;
    }
}