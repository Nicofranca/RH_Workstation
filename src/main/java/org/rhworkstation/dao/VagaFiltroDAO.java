package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.model.Vaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VagaFiltroDAO {

    public static List<Vaga> listarVagasPorFaixaSalarial(Double salarioMin, Double salarioMax) throws SQLException {
        List<Vaga> vagas = new ArrayList<>();

        String query = "SELECT id, nome_vaga, descricao, salario_hora FROM vagas WHERE 1=1";

        if (salarioMin != null) {
            query += " AND salario_hora >= ?";
        }
        if (salarioMax != null) {
            query += " AND salario_hora <= ?";
        }

        query += " ORDER BY salario_hora DESC";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            int index = 1;
            if (salarioMin != null) {
                stmt.setDouble(index++, salarioMin);
            }
            if (salarioMax != null) {
                stmt.setDouble(index++, salarioMax);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vaga vaga = new Vaga();

                    vaga.setId(rs.getInt("id"));
                    vaga.setNomeVaga(rs.getString("nome_vaga"));
                    vaga.setDescricao(rs.getString("descricao"));
                    vaga.setSalarioHora(rs.getDouble("salario_hora"));
                    vagas.add(vaga);
                }
            }

        }

        return vagas;
    }

}