package org.rhworkstation.service;

import org.rhworkstation.dao.AdminDAO;
import org.rhworkstation.dao.CandidatoDAO;
import org.rhworkstation.dao.ColaboradorDAO;
import org.rhworkstation.dao.VagaDAO;
import org.rhworkstation.model.Admin;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.view.Inputs;
import org.rhworkstation.exception.RHException;

import java.sql.SQLException;
import java.util.List;

public class AdminService {

    Inputs input = new Inputs();

    public boolean loginAdmin(String email, String senha){
        boolean adminEncontrado = false;
        var adminDAO = new AdminDAO();

        try {
            Admin admin = adminDAO.verificacaoAdmin(email, senha);
            if (admin != null){
                adminEncontrado = true;
                System.out.println("Login bem-sucedido! Bem-vindo(a) admin, "+admin.getNome());
            }

        } catch (RHException e){
            System.out.println("Erro ao realizar login: " + e.getMessage());
            e.printStackTrace();
        }

        return adminEncontrado;
    }

    public void tornarColaborador(){

    }

}