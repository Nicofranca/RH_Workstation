package org.rhworkstation.model;

import java.time.LocalDate;
import java.util.Date;

public class SolicitacaoFerias {

    private int id;
    private int colaborador_id;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private String status_solicitacao;

    public SolicitacaoFerias() {}

    public SolicitacaoFerias(int id) {
        this.id = id;
    }

    public SolicitacaoFerias(int id, int colaborador_id, LocalDate data_inicio, LocalDate data_fim, String status_solicitacao) {
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

    public LocalDate getData_inicio() {
        return data_inicio;
    }
    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }
    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

    public String getStatus_solicitacao() {
        return status_solicitacao;
    }
    public void setStatus_solicitacao(String status_solicitacao) {
        this.status_solicitacao = status_solicitacao;
    }

}