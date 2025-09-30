package org.rhworkstation.model;

import org.rhworkstation.model.enums.StatusVaga;

public class Vaga {

    private int id;
    private String nomeVaga;
    private String descricao;
    private double salarioHora;

    public Vaga(int id, String nomeVaga, String descricao, double salarioHora) {
        this.id = id;
        this.nomeVaga = nomeVaga;
        this.descricao = descricao;
        this.salarioHora = salarioHora;
    }

    public Vaga(String nomeVaga, String descricao, double salarioHora) {
        this.nomeVaga = nomeVaga;
        this.descricao = descricao;
        this.salarioHora = salarioHora;
    }


    // Getters e Setters
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

    @Override
    public String toString() {
        return "Vaga [id=" + id + ", nomeVaga=" + nomeVaga + ", descricao=" + descricao + ", salarioHora=" + salarioHora + "]";
    }

}