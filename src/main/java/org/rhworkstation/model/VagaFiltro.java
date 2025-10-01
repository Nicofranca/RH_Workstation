package org.rhworkstation.model;

public class VagaFiltro {

    private Double salarioMin;
    private Double salarioMax;

    public VagaFiltro() {}

    public VagaFiltro(Double salarioMin, Double salarioMax) {
        this.salarioMin = salarioMin;
        this.salarioMax = salarioMax;
    }

    // Getters e Setters
    public Double getSalarioMin() {
        return salarioMin;
    }
    public void setSalarioMin(Double salarioMin) {
        this.salarioMin = salarioMin;
    }

    public Double getSalarioMax() {
        return salarioMax;
    }
    public void setSalarioMax(Double salarioMax) {
        this.salarioMax = salarioMax;
    }

}