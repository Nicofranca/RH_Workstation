package org.rhworkstation.service;

import org.rhworkstation.dao.CandidatoDAO;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;
import java.util.List;

public class CandidatoService {

    Inputs data = new Inputs();

    public void criarUsuario(){

        String nome = data.inputNome();
        String cpf = data.inputCpf();
        String email = data.inputEmail();
        String senha = data.inputSenha();

        var novoCandidato = new Candidato(nome, email, cpf, senha);
        var candidatoDAO = new CandidatoDAO();

        try {
            candidatoDAO.criarCandidato(novoCandidato);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarVagas() {
        try {
            List<Vaga> vagas = CandidatoDAO.listarVagas();

            if (vagas.isEmpty()) {
                System.out.println("Não há vagas cadastrados.");
                return;
            }

            System.out.println("=== Lista de Vagas ===");
            for (Vaga vaga : vagas) {
                System.out.println("ID: " + vaga.getId());
                System.out.println("Nome da Vaga: " + vaga.getNomeVaga());
                System.out.println("Descrição: " + vaga.getDescricao());
                System.out.println("Salário Hora: " + vaga.getSalarioHora());
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}