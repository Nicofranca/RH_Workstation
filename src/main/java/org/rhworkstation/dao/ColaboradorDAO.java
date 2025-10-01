package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.dto.DadosFolhaSalarialDTO;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.model.FolhaSalarial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {

    public void atualizarSenha(int id, String novaSenha) throws SQLException {
        String query = "UPDATE colaborador SET senha = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, novaSenha);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void atualizarEmail(int id, String novoEmail) throws SQLException {
        String query = "UPDATE colaborador SET email = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, novoEmail);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void gerarDadosParaFolhaSalarial() throws SQLException {

    }

    public Colaborador loginColaborador(String email, String senha) throws SQLException{
        String query = "SELECT id, nome, cpf, email, cargo, departamento, salario_hora, senha, horas_de_trabalho FROM colaborador WHERE email = ? AND senha = ?";
        Colaborador colaborador = null;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    colaborador = new Colaborador();
                    colaborador.setId(rs.getInt("id"));
                    colaborador.setNome(rs.getString("nome"));
                    colaborador.setEmail(rs.getString("email"));
                    colaborador.setSenha(rs.getString("senha"));
                    colaborador.setCpf(rs.getString("cpf"));
                    colaborador.setDepartamento(rs.getString("departamento"));
                    colaborador.setCargo(rs.getString("cargo"));
                    colaborador.setSalario_hora(rs.getDouble("salario_hora"));
                }
            }
        }

        return colaborador;

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