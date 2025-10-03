package org.rhworkstation.service;

import org.rhworkstation.dao.VagaDAO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.utils.Utils;
import org.rhworkstation.view.Inputs;


public class VagaService {
    Utils utils = new Utils();
    Inputs input = new Inputs();

    public void criarVaga() {
        String nomeVaga = input.inputNomeVaga();
        String descricao = input.inputDescricaoVaga();
        double salarioHora = input.inputSalarioHoraVaga();

        Vaga vaga = new Vaga(nomeVaga, descricao, salarioHora);

        try {
            VagaDAO.criarVaga(vaga);
            System.out.println("Vaga criada com sucesso!");

        } catch (RHException e) {
            System.out.println("Erro ao criar vaga: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void excluirVaga() {
        int id = input.inputID();

        try {
            VagaDAO.excluirVaga(id);
            System.out.println("Vaga excluída com sucesso!");

        } catch (RHException e) {
            System.out.println("Erro ao excluir vaga: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void editarVaga() {
        int id = input.inputID();
        utils.limparScanner();
        String nomeVaga = input.inputNomeVaga();
        String descricao = input.inputDescricaoVaga();
        double salarioHora = input.inputSalarioHoraVaga();

        Vaga vaga = new Vaga(nomeVaga, descricao, salarioHora);
        vaga.setId(id);

        try {
            VagaDAO.editarVaga(vaga);
            System.out.println("Vaga atualizada com sucesso!");

        } catch (RHException e) {
            System.out.println("Erro ao atualizar a vaga: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
