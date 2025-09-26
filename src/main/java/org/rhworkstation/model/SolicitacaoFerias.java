package org.rhworkstation.model;

import java.util.Date;

public class SolicitacaoFerias {

    private int id;
    private int colaborador_id;
    private Date data_inicio;
    private Date data_fim;
    private String status_solicitacao;

    public SolicitacaoFerias() {}

    public SolicitacaoFerias(int id) {
        this.id = id;
    }

    public SolicitacaoFerias(int id, int colaborador_id, Date data_inicio, Date data_fim, String status_solicitacao) {
        this.id = id;
        this.colaborador_id = colaborador_id;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.status_solicitacao = status_solicitacao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getColaborador_id() {
        return colaborador_id;
    }
    public void setColaborador_id(int colaborador_id) {
        this.colaborador_id = colaborador_id;
    }

    public Date getData_inicio() {
        return data_inicio;
    }
    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }
    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public String getStatus_solicitacao() {
        return status_solicitacao;
    }
    public void setStatus_solicitacao(String status_solicitacao) {
        this.status_solicitacao = status_solicitacao;
    }

}