package org.rhworkstation.model;

import org.rhworkstation.model.enums.StatusVaga;

public class Vaga {

    private int id;
    private String nomeVaga;
    private String descricao;
    private double salarioHora;
    private StatusVaga status;

    public Vaga(int id, String nomeVaga, String descricao, double salarioHora, StatusVaga status) {
        this.id = id;
        this.nomeVaga = nomeVaga;
        this.descricao = descricao;
        this.salarioHora = salarioHora;
        this.status = status;
    }

    public Vaga(String nomeVaga, String descricao, double salarioHora, StatusVaga status) {
        this.nomeVaga = nomeVaga;
        this.descricao = descricao;
        this.salarioHora = salarioHora;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeVaga() {
        return  nomeVaga;
    }

    public void setNomeVaga(String nomeVaga){
        this.nomeVaga = nomeVaga;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public StatusVaga getStatus() {
        return status;
    }

    public void setStatus(StatusVaga status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vaga [id=" + id + ", nomeVaga=" + nomeVaga + ", descricao=" + descricao + ", salarioHora=" + salarioHora + ", status=" + status + "]";
    }

}

