package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.RegistroFalta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroFaltaDAO {

    public void RegistrarFalta(RegistroFalta falta) throws RHException {
        String query = "INSERT INTO faltas_trabalho(cpf_colaborador,horas_faltas) values (?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);) {

            stmt.setString(1, falta.getCpfColaborador());
            stmt.setDouble(2, falta.getHorasFaltas());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao registrar falta", e);
        }
    }
}