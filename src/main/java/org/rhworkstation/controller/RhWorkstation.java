package org.rhworkstation.controller;

import org.rhworkstation.service.CandidatoSevice;
import org.rhworkstation.service.LoginService;
import org.rhworkstation.view.Inputs;
import org.rhworkstation.view.Menus;

import java.awt.*;

import java.sql.SQLException;

public class RhWorkstation {
    CandidatoController candidatoController = new CandidatoController();
    ColaboradorController colaboradorController = new ColaboradorController();
    AdminController adminController = new AdminController();
    Menus menus = new Menus();

    public void Application(){
        var menu = new Menus();
        boolean logout = false;

        while(!logout){

            switch (menu.menuUsuario()){
                case 1 -> candidatoController.iniciar();
                case 0 -> {
                    menus.menuFinal();
                    logout = true;
                }
            }
        }
    }
}