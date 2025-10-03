package org.rhworkstation.service;

import org.rhworkstation.dao.ColaboradorDAO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;

public class ColaboradorService {

    Inputs input = new Inputs();

    public void atualizarSenha() {
        int id = input.inputID();
        input.limparScanner();
        String novaSenha = input.inputSenha();

        var colaboradorDAO = new ColaboradorDAO();

        try {
            colaboradorDAO.atualizarSenha(id, novaSenha);
            System.out.println("Senha atualizada com sucesso!");

        } catch (RHException e) {
            System.out.println("Erro ao atualizar senha: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void atualizarEmail() {
        int id = input.inputID();
        input.limparScanner();
        String novoEmail = input.inputEmail();

        var colaboradorDAO = new ColaboradorDAO();

        try {
            colaboradorDAO.atualizarEmail(id, novoEmail);
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