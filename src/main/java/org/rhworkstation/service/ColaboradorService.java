package org.rhworkstation.service;

import org.rhworkstation.dao.ColaboradorDAO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;

import static org.rhworkstation.utils.Utils.limparScanner;

public class ColaboradorService {

    Inputs input = new Inputs();

    public void atualizarSenhaColaborador() {
        int id = input.inputID();
        limparScanner();
        String novaSenha = input.inputSenha();

        var colaboradorDAO = new ColaboradorDAO();

        try {
            colaboradorDAO.atualizarSenhaColaborador(id, novaSenha);
            System.out.println("Senha atualizada com sucesso!");

        } catch (RHException e) {
            System.out.println("Erro ao atualizar senha: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void editarColaborador() {
        int id = input.inputID();
        limparScanner();
        String nome = input.inputNome();
        String cpf = input.inputCpf();
        String email = input.inputEmail();
        String cargo = input.inputCargo();
        String departamento = input.inputDepartamento();
        double salarioHora = input.inputSalarioHora();
        limparScanner();
        String senha = input.inputSenha();

        var colaborador = new Colaborador(id, nome, cpf, email, cargo, departamento, salarioHora, senha);
        var colaboradorDAO = new ColaboradorDAO();

        try {
            colaboradorDAO.editarColaborador(colaborador);
            System.out.println("Colaborador atualizado com sucesso!");

        } catch (RHException e) {
            System.out.println("Erro ao atualizar colaborador: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void desligarColaborador() {
        int id = input.inputID();

        var colaborador = new ColaboradorDAO();

        try {
            colaborador.desligarColaborador(id);
            System.out.println("Colaborador desligado com sucesso!");

        } catch (RHException e) {
            System.out.println("Erro ao desligar colaborador: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void criarColaborador() {
        limparScanner();

        String nome = input.inputNome();
        String cpf = input.inputCpf();
        String email = input.inputEmail();
        String senha = input.inputSenha();
        String cargo = input.inputCargo();
        String departamento = input.inputDepartamento();
        double salarioHora = input.inputSalarioHora();
        int horaDeTrabalho = input.inputHorasDeTrabalho();


        var colaborador = new Colaborador(nome, cpf, email, cargo, departamento, salarioHora, senha, horaDeTrabalho);
        var colaboradorDAO = new ColaboradorDAO();

        try {
            colaboradorDAO.criarColaborador(colaborador);
            System.out.println("Colaborador inserido com sucesso!");

        } catch (RHException e) {
            System.out.println("Erro ao inserir colaborador: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void atualizarEmail() {
        int id = input.inputID();
        limparScanner();
        String novoEmail = input.inputEmail();

        var colaboradorDAO = new ColaboradorDAO();

        try {
            colaboradorDAO.atualizarEmailColaborador(id, novoEmail);
            System.out.println("Email atualizado com sucesso!");

        } catch (RHException e) {
            System.out.println("Erro ao atualizar email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean loginColaborador(String email, String senha){
        boolean colaboradorEncontrado = false;

        var colaboradorDAO = new ColaboradorDAO();

        try {
            Colaborador colaborador = colaboradorDAO.loginColaborador(email, senha);
            if (colaborador != null){
                colaboradorEncontrado = true;
                System.out.println("Login bem-sucedido! Bem-vindo(a) colaborador, "+ colaborador.getNome());
            }

        } catch (RHException e) {
            System.out.println("Erro ao realizar login: "+ e.getMessage());
            e.printStackTrace();
        }

        return colaboradorEncontrado;
    }

}