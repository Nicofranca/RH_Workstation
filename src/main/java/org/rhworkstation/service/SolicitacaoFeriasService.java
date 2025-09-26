package org.rhworkstation.service;

import org.rhworkstation.dao.SolicitacaoFeriasDAO;
import org.rhworkstation.model.SolicitacaoFerias;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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

    public void listarSolicitacoes() {
        try {
            List<SolicitacaoFerias> lista = SolicitacaoFeriasDAO.listarSolicitacoes();
            for (SolicitacaoFerias solicitacaoFerias : lista) {
                System.out.println("ID: " + solicitacaoFerias.getId() + " | Colaborador: " + solicitacaoFerias.getColaborador_id() +
                        "\nInício: " + solicitacaoFerias.getData_inicio() + " | Fim: " + solicitacaoFerias.getData_fim() +
                        "\nStatus: " + solicitacaoFerias.getStatus_solicitacao() + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar solicitações de férias!");
            e.printStackTrace();
        }
    }

}