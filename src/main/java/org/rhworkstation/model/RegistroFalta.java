package org.rhworkstation.model;

public class RegistroFalta{

    private String cpfColaborador;
    private double horasFaltas;

    public RegistroFalta(String cpfColaborador, double horasFaltas) {
        this.cpfColaborador = cpfColaborador;
        this.horasFaltas = horasFaltas;
    }

    public String getCpfColaborador() {
        return cpfColaborador;
    }

    public void setCpfColaborador(String cpfColaborador) {
        this.cpfColaborador = cpfColaborador;
    }

    public double getHorasFaltas() {
        return horasFaltas;
    }

    public void setHorasFaltas(double horasFaltas) {
        this.horasFaltas = horasFaltas;
    }
}
