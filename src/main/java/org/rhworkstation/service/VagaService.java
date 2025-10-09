package org.rhworkstation.service;

import org.rhworkstation.dao.CandidatoDAO;
import org.rhworkstation.dao.VagaDAO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.utils.Utils;
import org.rhworkstation.view.Inputs;

import java.util.List;

import static org.rhworkstation.view.Mensagens.*;


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
            vagaCriadaSucesso();

        } catch (RHException e) {
            System.err.println("                    Erro ao criar vaga: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listarVagas() {
        try {
            List<Vaga> vagas = CandidatoDAO.listarVagas();

            if (vagas.isEmpty()) {
                System.err.println("                    Não há vagas cadastrados.");
                return;
            }

                System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("                    ┃                 Lista de Vagas                   ┃");
                System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            for (Vaga vaga : vagas) {
                System.out.println("                    - ID: " + vaga.getId());
                System.out.println("                    ---------------------------------------------------");
                System.out.println("                    - Nome da Vaga: " + vaga.getNomeVaga());
                System.out.println("                    ---------------------------------------------------");
                System.out.println("                    - Descrição: " + vaga.getDescricao());
                System.out.println("                    ---------------------------------------------------");
                System.out.println("                    - Salário Hora: " + vaga.getSalarioHora());
                System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

            }

        } catch (RHException e) {
            System.err.println("                    Erro ao listar candidatos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void excluirVaga() {
        int id = input.inputID();

        try {
            VagaDAO.excluirVaga(id);
            vagaExcluidaSucesso();

        } catch (RHException e) {
            System.err.println("                    Erro ao excluir vaga: " + e.getMessage());
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
            vagaEditadaSucesso();

        } catch (RHException e) {
            System.err.println("                    Erro ao atualizar a vaga: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
