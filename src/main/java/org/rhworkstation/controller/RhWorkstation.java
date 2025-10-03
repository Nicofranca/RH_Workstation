package org.rhworkstation.controller;

import org.rhworkstation.view.Menus;

public class RhWorkstation {
    CandidatoController candidatoController = new CandidatoController();
    ColaboradorController colaboradorController = new ColaboradorController();
    AdminController adminController = new AdminController();
    LoginController loginController = new LoginController();
    Menus menus = new Menus();

    public void Application(){
        var menu = new Menus();
        boolean logout = false;

        while(!logout){

            switch (menu.menuInicial()){
                case 1 -> candidatoController.criarCandidato();
                case 2 -> loginController.login();
                case 0 -> {
                    menus.menuFinal();
                    logout = true;
                }
            }
        }
    }
}