package org.rhworkstation.controller;

import org.rhworkstation.service.ColaboradorService;
import org.rhworkstation.service.FolhaSalarialService;
import org.rhworkstation.service.SolicitacaoFeriasService;
import org.rhworkstation.view.Inputs;
import org.rhworkstation.view.Menus;

import java.awt.*;

public class ColaboradorController {
    public void iniciarMenuColaborador(){
        Inputs inputs = new Inputs();
        ColaboradorService colaboradorService = new ColaboradorService();
        FolhaSalarialService folhaSalarialService = new FolhaSalarialService();
        SolicitacaoFeriasService solicitacaoFeriasService = new SolicitacaoFeriasService();
        Menus menu = new Menus();

        boolean saida = false;

        while (!saida){
            boolean loop = false;
            while(!loop){
                switch (menu.menuColaborador()){
                    case 1 -> folhaSalarialService.OlharFolhaSalarial();
                    case 2 -> solicitacaoFeriasService.criarSolicitacao();
                    case 0 -> {
                        loop = true;
                    }
                }
            }
            return;
        }
    }
}
