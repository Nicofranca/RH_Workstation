package org.rhworkstation.model;

public class Colaborador {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String cargo;
    private String departamento;
    private double salarioHora;

    public Colaborador() {}

    public Colaborador(int id, String nome, String cpf, String email, String cargo, String departamento, double salarioHora) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salarioHora = salarioHora;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalarioHora() {
        return salarioHora;
    }
    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

}