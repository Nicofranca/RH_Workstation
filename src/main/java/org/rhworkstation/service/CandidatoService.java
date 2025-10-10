package org.rhworkstation.service;

import org.rhworkstation.context.CacheContext;
import org.rhworkstation.dao.CandidatoDAO;
import org.rhworkstation.dao.VagaDAO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;
import java.util.List;


import static org.rhworkstation.context.CacheContext.getCacheCpf;

import static org.rhworkstation.utils.Utils.inputNumber;

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
            System.out.println("                    Erro ao criar usuário: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listarCandidatos() {
        try {
            List<Candidato> candidatos = CandidatoDAO.listarCandidatos();

            if (candidatos.isEmpty()) {
                System.out.println("                    Não há candidatos cadastrados.");
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
            System.out.println("                    Erro ao listar candidatos: " +e.getMessage());
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
            System.out.println("                    Erro ao tentar fazer login do candidato: " + e.getMessage());
            e.printStackTrace();
        }

        return candidatoEncontrado;
    }

    public void OlharVagas(){
        try {
            List<Vaga> vagas = VagaDAO.listarVagas();

            if (vagas.isEmpty()) {
                System.out.println("                    Não há vagas cadastrados.");
                return;
            }

                System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("                    ┃                       VAGAS                       ┃");
                System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

                for (int i = 0; i < vagas.size(); i++) {
                    System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.println("                    - Nome da Vaga: " + vagas.get(i).getNomeVaga());
                    System.out.println("                    -----------------------------------------------------");
                    System.out.println("                    - Descrição: " + vagas.get(i).getDescricao());
                    System.out.println("                    -----------------------------------------------------");
                    System.out.println("                    - Salário Hora: " + vagas.get(i).getSalarioHora());
                    System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                    System.out.println("                    | (1)Candidatar-se | (2)Voltar | (3)Próximo | (0)Sair ");
                    switch (inputNumber()) {
                        case 1 -> {
                            var candidato = new CandidatoDAO();
                            candidato.CandidatarSe(getCacheCpf(),vagas.get(i).getId());
                        }
                        case 2 -> {
                            i-= 2;
                        }
                        case 3 ->{}
                        case 0 -> {
                            return;
                        }
                        default -> {
                            System.out.println("\u001b[31m                    Opção não existe! Tente denovo!\u001b[0m");
                        }
                    }
                }


        } catch (RHException e) {
            System.out.println("                    Erro ao listar candidatos: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CandidatoService candidatoService = new CandidatoService();
        candidatoService.OlharVagas();
    }
}