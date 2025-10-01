package org.rhworkstation.model;

import java.time.LocalDate;

public class FolhaSalarial {

    private int id;
    private String cpf_colaborador;
    private double salario_bruto;
    private double inss;
    private double salario_liquido;
    private LocalDate dataFolhaSalarial;

    public FolhaSalarial(int id, String cpf_colaborador, double salario_bruto, double inss, double salario_liquido,LocalDate dataFolhaSalarial) {
        this.id = id;
        this.cpf_colaborador = cpf_colaborador;
        this.salario_bruto = salario_bruto;
        this.inss = inss;
        this.salario_liquido = salario_liquido;
        this.dataFolhaSalarial = LocalDate.now();
        //isso vai definir a data automaticamente quando for liberado
    }

    public FolhaSalarial(String cpf_colaborador, double salario_bruto, double inss, double salario_liquido,LocalDate dataFolhaSalarial) {
        this.cpf_colaborador = cpf_colaborador;
        this.salario_bruto = salario_bruto;
        this.inss = inss;
        this.salario_liquido = salario_liquido;
        this.dataFolhaSalarial = LocalDate.now();
        //isso vai definir a data automaticamente quando for liberado
    }

    public FolhaSalarial() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf_colaborador() {
        return cpf_colaborador;
    }

    public void setCpf_colaborador(String cpf_colaborador) {
        this.cpf_colaborador = cpf_colaborador;
    }

    public double getSalario_bruto() {
        return salario_bruto;
    }

    public void setSalario_bruto(double salario_bruto) {
        this.salario_bruto = salario_bruto;
    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getSalario_liquido() {
        return salario_liquido;
    }

    public void setSalario_liquido(double salario_liquido) {
        this.salario_liquido = salario_liquido;
    }

    public LocalDate getDataFolhaSalarial() {
        return dataFolhaSalarial;
    }

    public void setDataFolhaSalarial(LocalDate dataFolhaSalarial) {
        this.dataFolhaSalarial = dataFolhaSalarial;
    }
}
