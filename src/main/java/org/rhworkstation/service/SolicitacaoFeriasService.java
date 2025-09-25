package org.rhworkstation.service;

import org.rhworkstation.dao.SolicitacaoFeriasDAO;
import org.rhworkstation.model.SolicitacaoFerias;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;
import java.util.Date;

public class SolicitacaoFeriasService {

    Inputs input = new Inputs();

    public void criarSolicitacao() {
        int colaboradorId = input.inputID();
        Date dataInicio = input.inputDataInicio();
        Date dataFim = input.inputDataFim();
        String status = "PENDENTE";

        SolicitacaoFerias solicitacaoFerias = new SolicitacaoFerias(0, colaboradorId, dataInicio, dataFim, status);

        try {
            SolicitacaoFeriasDAO.criarSolicitacao(solicitacaoFerias);
            System.out.println("Solicitação de férias criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar solicitação de férias no banco de dados!");
            e.printStackTrace();
        }
    }

}