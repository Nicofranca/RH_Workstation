package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Curriculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CurriculoDAO {

    public void criarCurriculo(Curriculo curriculo) throws RHException {
        String query = "INSERT INTO curriculo (idade, sexo, formacao, texto, id_candidato) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, curriculo.getIdade());
            stmt.setString(2, curriculo.getSexo());
            stmt.setString(3, curriculo.getFormacao());
            stmt.setString(4, curriculo.getTexto());
            stmt.setObject(5, curriculo.getId_candidato());
            stmt.executeUpdate();

            System.out.println("Curriculo Criado!");

        } catch (SQLException e) {
            throw new RHException("Erro ao criar curriculo", e);
        }
    }

    public void excluirCurriculo(int id) throws RHException {
        String query = "DELETE FROM curriculo WHERE id_candidato = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Curriculo excluido com sucesso!");

        } catch (SQLException e) {
            throw new RHException("Erro ao excluir curriculo", e);
        }
    }

    public void editarCurriculo(Curriculo curriculo, int id) throws RHException{
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        String query = "UPDATE curriculo SET idade = ?, sexo = ?, formacao = ?, texto = ? WHERE id_candidato = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, curriculo.getIdade());
            stmt.setString(2, curriculo.getSexo());
            stmt.setString(3, curriculo.getFormacao());
            stmt.setString(4, curriculo.getTexto());
            stmt.setInt(5, id);
            stmt.executeUpdate();

            System.out.println("Curriculo editado com sucesso!");

        } catch (SQLException e) {
            throw new RHException("Erro ao editar curriculo", e);
        }
    }

}
