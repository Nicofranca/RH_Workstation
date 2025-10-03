package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.FolhaSalarial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class FolhaSalarialDAO {

    public void CriarFolhaSalarial(FolhaSalarial folha) throws RHException {
        String query = "INSERT INTO FolhaSalarial (id,cpf_colaborador,salario_bruto,inss,salario_liquido,data_folha_salarial) VALUES (?,?,?,?,?,?) ";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1,folha.getId());
            stmt.setString(2,folha.getCpf_colaborador());
            stmt.setDouble(3,folha.getSalario_bruto());
            stmt.setDouble(4,folha.getInss());
            stmt.setDouble(5,folha.getSalario_liquido());
            stmt.setDate(6,java.sql.Date.valueOf(folha.getDataFolhaSalarial()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RHException("Erro ao criar folha salarial", e);
        }
    }

}