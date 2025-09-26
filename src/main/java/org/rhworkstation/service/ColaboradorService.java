package org.rhworkstation.service;

import org.rhworkstation.dao.ColaboradorDAO;
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
        } catch (SQLException e) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}