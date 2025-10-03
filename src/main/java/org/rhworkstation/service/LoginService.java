package org.rhworkstation.service;

import org.rhworkstation.model.Admin;
import org.rhworkstation.view.Inputs;
import org.rhworkstation.view.Menus;

import java.sql.SQLException;

public class LoginService {

    Inputs input = new Inputs();
    AdminService adminService = new AdminService();
    ColaboradorService colaboradorService = new ColaboradorService();
    CandidatoService candidatoService = new CandidatoService();
    Menus menus = new Menus();

    public void login() {
        String email = input.inputEmail();
        String senha = input.inputSenha();

        try {
            if (adminService.loginAdmin(email, senha)) {
                menus.menuAdmin();
                return;
            }

            else if (candidatoService.loginCandidato(email, senha)) {
                menus.menuCandidato();
                return;
            }

            else if (colaboradorService.loginColaborador(email, senha)) {
                menus.menuColaborador();
                return;
            }

            else {
                System.out.println("Usuário não encontrado. Verifique suas credenciais ou cadastre-se!");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String autenticarUsuario(String email, String senha) {
        if (adminService.loginAdmin(email, senha)){
            return "ADMIN";
        } else if (colaboradorService.loginColaborador(email, senha)) {
            return "COLABORADOR";
        } else if (candidatoService.loginCandidato(email, senha)) {
            return "CANDIDATO";
        }

        return null;
    }

}