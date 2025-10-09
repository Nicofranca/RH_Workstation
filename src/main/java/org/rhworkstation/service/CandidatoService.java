package org.rhworkstation.service;

import org.rhworkstation.context.CacheContext;
import org.rhworkstation.dao.CandidatoDAO;
import org.rhworkstation.exception.RHException;
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

        } catch (RHException e) {
            System.err.println("                    Erro ao criar usuário: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listarCandidatos() {
        try {
            List<Candidato> candidatos = CandidatoDAO.listarCandidatos();

            if (candidatos.isEmpty()) {
                System.err.println("                    Não há candidatos cadastrados.");
                return;
            }

                System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("                    ┃               Lista de Candidatos                ┃");
                System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            for (Candidato candidato : candidatos) {
                System.out.println("                    - Nome: " + candidato.getNome());
                System.out.println("                    ---------------------------------------------------");
                System.out.println("                    - Cpf: " + candidato.getCpf());
                System.out.println("                    ---------------------------------------------------");
                System.out.println("                    - Email: " + candidato.getEmail());
                System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

            }

        } catch (RHException e) {
            System.err.println("                    Erro ao listar candidatos: " +e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean loginCandidato(String email, String senha) {
        boolean candidatoEncontrado = false;
        var candidatoDAO = new CandidatoDAO();

        try {
            Candidato candidato = candidatoDAO.verificacaoCandidato(email, senha);

            if (candidato != null) {
                candidatoEncontrado = true;
                System.out.println("\u001b[32m                    Login bem-sucedido!\u001b[0m Bem-vindo(a) candidato, " + candidato.getNome());
                CacheContext.setCacheCpf(candidato.getCpf());
            }

        } catch (SQLException e) {
            System.err.println("                    Erro ao tentar fazer login do candidato: " + e.getMessage());
            e.printStackTrace();
        }

        return candidatoEncontrado;
    }


}