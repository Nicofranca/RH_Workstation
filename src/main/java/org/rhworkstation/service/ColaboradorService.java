package org.rhworkstation.service;

import org.rhworkstation.dao.ColaboradorDAO;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;

public class ColaboradorService {

    Inputs input = new Inputs();

    public void desligarColaborador() {
        int id = input.inputID();

        var colaboradorDAO = new ColaboradorDAO();

        try {
            colaboradorDAO.desligarColaborador(id);
            System.out.println("Colaborador desligado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao desligar colaborador no banco de dados!");
            e.printStackTrace();
        }
    }

}