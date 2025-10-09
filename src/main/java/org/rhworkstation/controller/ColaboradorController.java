package org.rhworkstation.controller;

import org.rhworkstation.context.CacheContext;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.service.FolhaSalarialService;
import org.rhworkstation.view.Menus;

public class ColaboradorController {
    public void iniciarMenuColaborador() throws RHException {

        var menu = new Menus();
        var folhaSalarial = new FolhaSalarialService();
        boolean saida = false;

        while(!saida){
            switch (menu.menuColaborador()){
                case 1 ->{
                    folhaSalarial.OlharFolhaSalarial();
                }
                case 2 ->{

                }
                case 0 ->{
                    CacheContext.setCacheCpf(null);
                    saida = true;
                }
            }


        }

    }
}
