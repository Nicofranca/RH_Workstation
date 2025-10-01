package org.rhworkstation.service;

import org.rhworkstation.dao.ColaboradorDAO;
import org.rhworkstation.dto.DadosFolhaSalarialDTO;
import org.rhworkstation.dao.FolhaSalarialDAO;
import org.rhworkstation.model.FolhaSalarial;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FolhaSalarialService {

    ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

    public void LiberarFolhaSalarial() throws SQLException {

        List<DadosFolhaSalarialDTO> folha = colaboradorDAO.gerarDadosParaFolhaSalarial();

        if(!folha.isEmpty()){
            var folhaSalarialDAO = new FolhaSalarialDAO();
            for(DadosFolhaSalarialDTO c:folha){
            try {

                String cpf = c.cpf();
                double salarioBruto = ((c.horasDeTrabalho() * 25) - c.horasFaltas()) * c.salarioHora();
                double inss;
                if (salarioBruto <= 1518.00) {
                    inss = salarioBruto * 0.075;
                } else if (salarioBruto <= 2793.88) {
                    inss = (salarioBruto * 0.09) - 22.77;
                } else if (salarioBruto <= 4190.83) {
                    inss = (salarioBruto * 0.12) - 106.59;
                } else if (salarioBruto <= 8157.41) {
                    inss = (salarioBruto * 0.14) - 190.40;
                } else {
                    inss = 908.85;
                }
                double salarioLiquido = salarioBruto - inss;
                LocalDate data = LocalDate.now();

                var folhaSalarial = new FolhaSalarial(cpf, salarioBruto, inss, salarioLiquido, data);
                folhaSalarialDAO.CriarFolhaSalarial(folhaSalarial);
                System.out.println("cadastrado com sucesso");
                }catch (Exception e){
                System.out.println("Erro ao cadastrar FolhaSalarial");
                System.out.println("Mensagem: " + e.getMessage());
                e.printStackTrace();
            }
            }
        }

    }

    public static void main(String[] args) {

        FolhaSalarialService folio = new FolhaSalarialService();
        try {
            folio.LiberarFolhaSalarial();
        } catch (SQLException e) {}
    }
}
