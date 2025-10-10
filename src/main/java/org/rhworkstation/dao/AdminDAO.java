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

    public void tornarColaborador(Colaborador colaborador) throws RHException{
        String query = "INSERT INTO colaborador (nome, cpf, email, cargo, departamento, salario_hora, senha,horas_de_trabalho) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getCpf());
            stmt.setString(3, colaborador.getEmail());
            stmt.setString(4, colaborador.getCargo());
            stmt.setString(5, colaborador.getDepartamento());
            stmt.setDouble(6, colaborador.getSalario_hora());
            stmt.setString(7, colaborador.getSenha());
            stmt.setDouble(8, colaborador.getHorasDeTrabalho());
            stmt.executeUpdate();

            System.out.println("Novo colaborador Cadastrado!");


        } catch (SQLException e){
            throw new RHException("Erro ao cadastrar colaborador no banco! " + e);
        }
    }

    public void deletarCandidato(String cpf) throws RHException{
        String query = "DELETE FROM candidato WHERE cpf = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, cpf);
                stmt.executeUpdate();

        } catch (SQLException e){
                throw new RHException("Erro ao deletar candidato! "+e);
        }
    }

    public Candidato buscarPorCPF(String CPFCandidato) throws RHException{
        String query = "SELECT id, nome, email, cpf, senha FROM candidato WHERE cpf = (?)";

        Candidato candidatoEncontrado = null;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, CPFCandidato);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    candidatoEncontrado = new Candidato();
                    candidatoEncontrado.setId(rs.getInt("id"));
                    candidatoEncontrado.setNome(rs.getString("nome"));
                    candidatoEncontrado.setEmail(rs.getString("email"));
                    candidatoEncontrado.setCpf(rs.getString("cpf"));
                    candidatoEncontrado.setSenha(rs.getString("senha"));

                }
            }

        } catch (SQLException e) {
            throw new RHException("Erro ao buscar candidato", e);
        }

        return candidatoEncontrado;
    }
}