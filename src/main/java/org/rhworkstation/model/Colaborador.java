package org.rhworkstation.model;

public class Colaborador {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String cargo;
    private String departamento;
    private double salario_hora;
    private String senha;
    private int horasDeTrabalho;

    public Colaborador() {}

    public Colaborador(String nome, String cpf, String email, String cargo, String departamento, double salario_hora, String senha, int horasDeTrabalho) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario_hora = salario_hora;
        this.senha = senha;
        this.horasDeTrabalho = horasDeTrabalho ;
    }

    public Colaborador(int id, String nome, String cpf, String email, String cargo, String departamento, double salario_hora, String senha, int horasDeTrabalho) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario_hora = salario_hora;
        this.senha = senha;
        this.horasDeTrabalho = horasDeTrabalho ;
    }

    public Colaborador(int id, String nome, String cpf, String email, String cargo, String departamento, double salario_hora, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario_hora = salario_hora;
        this.senha = senha;
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

    public double getSalario_hora() {
        return salario_hora;
    }
    public void setSalario_hora(double salario_hora) {
        this.salario_hora = salario_hora;
    }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public int getHorasDeTrabalho() {
        return horasDeTrabalho;
    }

    public void setHorasDeTrabalho(int horasDeTrabalho) {
        this.horasDeTrabalho = horasDeTrabalho;
    }
}