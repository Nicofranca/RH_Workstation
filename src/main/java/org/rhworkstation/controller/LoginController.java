package org.rhworkstation.controller;

import org.rhworkstation.service.CandidatoService;
import org.rhworkstation.service.LoginService;
import org.rhworkstation.view.Inputs;

public class LoginController {
    Inputs inputs = new Inputs();
    LoginService loginService = new LoginService();
    AdminController adminController = new AdminController();
    CandidatoController candidatoController = new CandidatoController();
    ColaboradorController colaboradorController = new ColaboradorController();

    public void login(){
        String email = inputs.inputEmail();
        String senha = inputs.inputSenha();

        try {
            String tipoUsuario = loginService.autenticarUsuario(email, senha);

            if (tipoUsuario == null){
                System.out.println("Usuario não encontrado!");
                return;
            }

            switch (tipoUsuario){
                case "ADMIN" -> adminController.iniciarMenuAdmin();
                case "COLABORADOR" -> colaboradorController.iniciarMenuColaborador();
                case "CANDIDATO" -> candidatoController.iniciarMenuCandidato();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
