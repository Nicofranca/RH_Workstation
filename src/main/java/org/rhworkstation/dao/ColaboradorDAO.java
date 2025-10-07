package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.dto.DadosFolhaSalarialDTO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.model.FolhaSalarial;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {

    public void criarColaborador(Colaborador colaborador) throws RHException {
        String query = "INSERT INTO colaborador(nome, cpf, email, cargo, departamento, salario_hora, senha,horas_de_trabalho) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getCpf());
            stmt.setString(3, colaborador.getEmail());
            stmt.setString(4, colaborador.getCargo());
            stmt.setString(5, colaborador.getDepartamento());
            stmt.setDouble(6, colaborador.getSalario_hora());
            stmt.setString(7, colaborador.getSenha());
            stmt.setDouble(8,colaborador.getHorasDeTrabalho());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao criar colaborador", e);
        }
    }

    public static void editarColaborador(Colaborador colaborador) throws RHException {
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

        } catch (SQLException e) {
            throw new RHException("Erro ao editar colaborador", e);
        }
    }

    public void desligarColaborador(int id) throws RHException {
        String query = "DELETE FROM colaborador WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao desligar colaborador", e);
        }
    }

    public void atualizarSenhaColaborador(int id, String novaSenha) throws RHException {
        String query = "UPDATE colaborador SET senha = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, novaSenha);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao atualizar senha", e);
        }
    }

    public void atualizarEmailColaborador(int id, String novoEmail) throws RHException {
        String query = "UPDATE colaborador SET email = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, novoEmail);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao atualizar email", e);
        }
    }

    public Colaborador loginColaborador(String email, String senha) throws RHException {
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

        } catch (SQLException e) {
            throw new RHException("Erro ao realizar login", e);
        }

        return colaborador;
    }

    public List<DadosFolhaSalarialDTO> gerarDadosParaFolhaSalarial() throws RHException {

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

        } catch (SQLException e) {
            throw new RHException("Erro ao gerar folha salarial", e);
        }

        return folha;
    }

    public int buscarPorCPF(String CPFColaborador) throws RHException{
        String query = "SELECT id FROM colaborador WHERE cpf = (?)";

        Colaborador colaboradorEncontrado = null;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, CPFColaborador);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    colaboradorEncontrado = new Colaborador();

                    colaboradorEncontrado.setId(rs.getInt("id"));
                }
            }

        } catch (SQLException e) {
            throw new RHException("Erro ao buscar colaborador", e);
        }

        return colaboradorEncontrado.getId();
    }

}