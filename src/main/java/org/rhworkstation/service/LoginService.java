package org.rhworkstation.service;

import org.rhworkstation.model.Admin;
import org.rhworkstation.view.Inputs;
import org.rhworkstation.view.Menus;

import java.sql.SQLException;

public class LoginService {

    Inputs input = new Inputs();
    AdminService adminService = new AdminService();
    ColaboradorService colaboradorService = new ColaboradorService();
    Menus menus = new Menus();

    public void login() {
        String email = input.inputEmail();
        String senha = input.inputSenha();

        try {
            boolean adminEncontrado = adminService.loginAdmin(email, senha);
            if (adminEncontrado) {
                menus.menuAdmin();
                return;
            }

            boolean colaboradorEncontrado = colaboradorService.loginColaborador(email, senha);

            if (colaboradorEncontrado){
                menus.menuCandidato();
                return;
            }

            System.out.println("Usuario nao encontrado, cadastre-se!");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}