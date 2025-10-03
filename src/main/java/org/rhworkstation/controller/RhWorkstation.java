package org.rhworkstation.controller;

import org.rhworkstation.view.Menus;

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
