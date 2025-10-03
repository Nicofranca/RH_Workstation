package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.dto.Cache;
import org.rhworkstation.dto.FolhaSalarialDTO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.FolhaSalarial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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


    public List<FolhaSalarialDTO> VisualizarFolhaSalarial (String cpf) throws RHException {
        var folhaAtual = new ArrayList<FolhaSalarialDTO>();

        String query = "SELECT c.nome," +
                "f.cpf_colaborador," +
                "f.salario_bruto," +
                "f.inss," +
                "f.salario_liquido," +
                "f.data_folha_salarial" +
                " FROM FolhaSalarial f" +
                " JOIN colaborador c" +
                " ON f.cpf_colaborador = c.cpf" +
                " WHERE cpf_colaborador = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1,cpf);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){

                String  nome = rs.getString("nome");
                String  cpfColaborador = rs.getString("cpf_colaborador");
                double  salarioBruto = rs.getDouble("salario_bruto");
                double  inss = rs.getDouble("inss");
                double  salarioLiquido = rs.getDouble("salario_liquido");
                LocalDate data = LocalDate.parse(rs.getString("data_folha_salarial"));

                var valores = new FolhaSalarialDTO(nome,cpfColaborador,salarioBruto,inss,salarioLiquido,data);
                folhaAtual.add(valores);
            }

        } catch (SQLException e) {
            throw new RHException("Erro ao vizualizar folha salarial", e);
        }

        return folhaAtual;
    }
}
