package org.rhworkstation.service;

import org.rhworkstation.dao.VagaFiltroDAO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VagaFiltroService {

    Inputs input = new Inputs();

    public void listarVagasPorFaixaSalarial() {
        System.out.println("=== Filtro de Vagas por Valor da Hora ===");

        Double salarioMin = input.inputSalarioHoraMinimo();
        if (salarioMin <= 0) salarioMin = null;

        Double salarioMax = input.inputSalarioHoraMaximo();
        if (salarioMax <= 0) salarioMax = null;

        if (salarioMin != null && salarioMax != null && salarioMin > salarioMax) {
            Double temp = salarioMin;
            salarioMin = salarioMax;
            salarioMax = temp;
        }

        try {
            List<Vaga> vagas = VagaFiltroDAO.listarVagasPorFaixaSalarial(salarioMin, salarioMax);

            if (vagas.isEmpty()) {
                System.out.println("Não há vagas cadastradas nessa faixa salarial!");
                return;
            }

            System.out.println("=== Lista de Vagas por Faixa Salarial ===");
            for (Vaga vaga : vagas) {
                System.out.println("ID: " + vaga.getId());
                System.out.println("Nome da Vaga: " + vaga.getNomeVaga());
                System.out.println("Descrição: " + vaga.getDescricao());
                System.out.println("Salário Hora: " + vaga.getSalarioHora());
                System.out.println("---------------------------");
            }

        } catch (RHException e) {
            System.out.println("Erro ao filtrar vagas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listarVagasPorCargo() {
        System.out.println("=== Filtro de Vagas por Cargo ===");

        String cargo = input.inputCargo();

        List<Vaga> vagas = new ArrayList<>();

        try {
            vagas = VagaFiltroDAO.listarVagasPorCargo(cargo);

        } catch (RHException e) {
            System.out.println("Erro ao filtrar vagas: " + e.getMessage());
            e.printStackTrace();
        }

        if (vagas == null || vagas.isEmpty()) {
            System.out.println("Não há vagas cadastradas para esse cargo!");
            return;
        }

        System.out.println("=== Lista de Vagas por Cargo ===");
        for (Vaga vaga : vagas) {
            System.out.println("ID: " + vaga.getId());
            System.out.println("Nome da Vaga: " + vaga.getNomeVaga());
            System.out.println("Descrição: " + vaga.getDescricao());
            System.out.println("Salário Hora: " + vaga.getSalarioHora());
            System.out.println("---------------------------");
        }
    }

}