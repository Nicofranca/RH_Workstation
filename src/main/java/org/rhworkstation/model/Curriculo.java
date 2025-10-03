package org.rhworkstation.model;

import org.rhworkstation.dao.CandidatoDAO;

public class Curriculo {

    private int id;
    private int idade;
    private String sexo;
    private String formacao;
    private String texto;
    private int id_candidato;

    public Curriculo() {}

    public Curriculo(int idade, String sexo, String formacao, String texto) {
        this.idade = idade;
        this.sexo = sexo;
        this.formacao = formacao;
        this.texto = texto;
    }

    public Curriculo(int id, int idade, String sexo, String formacao, String texto, int id_candidato) {
        this.id = id;
        this.idade = idade;
        this.sexo = sexo;
        this.formacao = formacao;
        this.texto = texto;
        this.id_candidato = id_candidato;
    }

    public Curriculo(int idade, String sexo, String formacao, String texto, int id_candidato) {
        this.idade = idade;
        this.sexo = sexo;
        this.formacao = formacao;
        this.texto = texto;
        this.id_candidato = id_candidato;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(int id_candidato) {
        this.id_candidato = id_candidato;
    }

}