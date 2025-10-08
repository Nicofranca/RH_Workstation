package org.rhworkstation.service;

import org.rhworkstation.dao.VagaFiltroDAO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.rhworkstation.view.Mensagens.*;

public class VagaFiltroService {

    Inputs input = new Inputs();

    public void listarVagasPorFaixaSalarial() {

        filtroVagasValor();

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
                naoHaVagasFaixaSalarial();
                return;
            }

                System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("                    ┃       Lista de Vagas por Faixa Salarial          ┃");
                System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            for (Vaga vaga : vagas) {
                System.out.println("                    - Nome da Vaga: " + vaga.getNomeVaga());
                System.out.println("                    ---------------------------------------------------");
                System.out.println("                    - Descrição   : " + vaga.getDescricao());
                System.out.println("                    ---------------------------------------------------");
                System.out.println("                    - Salário Hora: " + vaga.getSalarioHora());
                System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            }

        } catch (RHException e) {
            System.err.println("                    Erro ao filtrar vagas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listarVagasPorCargo() {
        System.err.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.err.println("                    ┃       Lista de Vagas por Faixa Salarial          ┃");
        System.err.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        String cargo = input.inputCargo();

        List<Vaga> vagas = new ArrayList<>();

        try {
            vagas = VagaFiltroDAO.listarVagasPorCargo(cargo);

        } catch (RHException e) {
            System.err.println("                    Erro ao filtrar vagas: " + e.getMessage());
            e.printStackTrace();
        }

        if (vagas == null || vagas.isEmpty()) {
            naoHaVagasCargo();
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