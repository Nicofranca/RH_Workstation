package org.rhworkstation.model;

public class Curriculo {

    private int id;
    private int idade;
    private String sexo;
    private String formacao;
    private String texto;
    private Candidato id_candidato;

    public Curriculo() {}
    public Curriculo(int id, int idade, String sexo, String formacao, String texto, Candidato id_candidato) {
        this.id = id;
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

    public Candidato getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(Candidato id_candidato) {
        this.id_candidato = id_candidato;
    }

}