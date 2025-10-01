package org.rhworkstation.controller;

import org.rhworkstation.service.CandidatoSevice;
import org.rhworkstation.service.LoginService;
import org.rhworkstation.view.Inputs;
import org.rhworkstation.view.Menus;

import java.awt.*;

import java.sql.SQLException;

public class RhWorkstation {

    Menus menu = new Menus();
    Inputs data = new Inputs();
    CandidatoSevice candidatoSevice = new CandidatoSevice();
    LoginService loginService = new LoginService();

    public void Application(){

        int inputUsuario = menu.menuInicial();

        do{
            switch (inputUsuario){
                case 1 -> candidatoSevice.criarUsuario();
                case 2 -> loginService.login();



            }
        } while (inputUsuario != 0);



    }
}
