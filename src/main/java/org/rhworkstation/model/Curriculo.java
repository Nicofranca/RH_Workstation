package org.rhworkstation.model;

public class Curriculo {

    private int id;
    private int idade;
    private String sexo;
    private String formacao;
    private String texto;
    private int id_cliente;

    public Curriculo() {}
    public Curriculo(int id, int idade, String sexo, String formacao, String texto, int id_cliente) {
        this.id = id;
        this.idade = idade;
        this.sexo = sexo;
        this.formacao = formacao;
        this.texto = texto;
        this.id_cliente = id_cliente;
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

    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

}