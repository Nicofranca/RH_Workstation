package org.rhworkstation.service;

import org.rhworkstation.dao.SolicitacaoFeriasDAO;
import org.rhworkstation.exception.RHException;
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

        } catch (RHException e) {
            System.out.println("Erro ao criar solicitação de férias: " + e.getMessage());
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

        } catch (RHException e) {
            System.out.println("Erro ao listar solicitações de férias: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void atualizarStatusSolicitacao() {
        int id = input.inputID();

        System.out.println("\"novo status de solicitação (ex: APROVADO, REJEITADO, PENDENTE)\"");
        String status = input.inputTexto();

        try {
            SolicitacaoFeriasDAO.atualizarStatusSolicitacao(id, status.toUpperCase());
            System.out.println("Status de solicitação atualizado para " + status.toUpperCase());

        } catch (RHException e) {
            System.out.println("Erro ao atulizar status da solicitação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deletarSolicitacao() {
        int id = input.inputID();

        try {
            SolicitacaoFeriasDAO.deletarSolicitacao(id);
            System.out.println("Solicitação de férias deletada com sucesso!");

        } catch (RHException e) {
            System.out.println("Erro ao deletar solicitação: " + e.getMessage());
            e.printStackTrace();
        }
    }

}