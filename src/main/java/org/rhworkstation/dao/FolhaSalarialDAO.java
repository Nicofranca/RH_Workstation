package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.model.FolhaSalarial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class FolhaSalarialDAO {

    public void CriarFolhaSalarial(FolhaSalarial folha) throws SQLException {

        String query = "INSERT INTO FolhaSalarial (cpf_colaborador,salario_bruto,inss,salario_liquido,data_folha_salarial) VALUES (?,?,?,?,?) ";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1,folha.getCpf_colaborador());
            stmt.setDouble(2,folha.getSalario_bruto());
            stmt.setDouble(3,folha.getInss());
            stmt.setDouble(4,folha.getSalario_liquido());
            stmt.setDate(5,java.sql.Date.valueOf(folha.getDataFolhaSalarial()));
            stmt.executeUpdate();
        }
    }
}
