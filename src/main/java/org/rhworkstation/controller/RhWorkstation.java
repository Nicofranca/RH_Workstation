package org.rhworkstation.controller;

import org.rhworkstation.service.CandidatoSevice;
import org.rhworkstation.service.LoginService;
import org.rhworkstation.view.Inputs;
import org.rhworkstation.view.Menus;

import java.awt.*;

import java.sql.SQLException;

public class RhWorkstation {

    public void Application(){
        var menu = new Menus();
        boolean logout = false;

        while(!logout){

            switch (menu.menuInicial()){
                case 1->{}
                case 2 ->{}
                case 0->{
                    logout = true;
                }
            }
        }
    }
}
