package org.rhworkstation.controller;

import org.rhworkstation.context.CacheContext;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.service.ColaboradorService;
import org.rhworkstation.service.FolhaSalarialService;
import org.rhworkstation.service.SolicitacaoFeriasService;
import org.rhworkstation.view.Menus;

public class ColaboradorController {
    public void iniciarMenuColaborador() throws RHException {

        ColaboradorService colaborador = new ColaboradorService();
        SolicitacaoFeriasService solicitacaoFeriasService = new SolicitacaoFeriasService();
        var menu = new Menus();
        var folhaSalarial = new FolhaSalarialService();
        boolean saida = false;

        while(!saida){
            switch (menu.menuColaborador()){
                case 1 ->{
                    folhaSalarial.OlharFolhaSalarial();
                }
                case 2 ->{
                    solicitacaoFeriasService.criarSolicitacao();
                }

                case 3 ->{
                    colaborador.editarColaborador();
                }
                case 0 ->{
                    CacheContext.setCacheCpf(null);
                    saida = true;
                }
            }


        }

    }
}
