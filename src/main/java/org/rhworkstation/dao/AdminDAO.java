package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Admin;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.model.Vaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

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
            stmt.setInt(8,colaborador.getHorasDeTrabalho());
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

    public Admin verificacaoAdmin(String email, String senha) throws RHException{
        String query = "SELECT id, nome, email, ultimo_login, senha FROM administrador WHERE email = ? AND senha = ?";
        Admin admin = null;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    admin = new Admin();
                    admin.setId(rs.getInt("id"));
                    admin.setEmail(rs.getString("email"));
                    admin.setNome(rs.getString("nome"));
                    admin.setSenha(rs.getString("senha"));

                    if (rs.getTimestamp("ultimo_login") != null){
                        admin.setUltimo_login(rs.getTimestamp("ultimo_login").toLocalDateTime());
                    }
                }
            }

        } catch (SQLException e) {
            throw new RHException("Erro ao verificar admin", e);
        }

        return admin;
    }

}