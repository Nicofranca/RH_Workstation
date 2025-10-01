package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.dto.DadosFolhaSalarialDTO;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.model.FolhaSalarial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {

    public void editarColaborador(Colaborador colaborador) throws SQLException {
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

    public List<DadosFolhaSalarialDTO> gerarDadosParaFolhaSalarial() throws SQLException {

        List<DadosFolhaSalarialDTO> folha = new ArrayList<>();
        String query = "SELECT " +
                "cpf," +
                "c.salario_hora," +
                "c.horas_de_trabalho," +
                "IFNULL(SUM(f.horas_faltas), 0) AS horas_faltas " +
                "FROM colaborador c " +
                "LEFT JOIN faltas_trabalho f " +
                "ON c.cpf = f.cpf_colaborador " +
                "GROUP BY c.cpf, c.salario_hora, c.horas_de_trabalho;";
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt =  conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String cpf = rs.getString("cpf");
                double salario_hora = rs.getDouble("salario_hora");
                double horas_de_trabalho = rs.getDouble("horas_de_trabalho");
                double horas_faltas = rs.getDouble("horas_faltas");

                var colaborador = new DadosFolhaSalarialDTO(cpf,salario_hora,horas_de_trabalho,horas_faltas);
                folha.add(colaborador);
            }

        }

        return folha;
    }

}