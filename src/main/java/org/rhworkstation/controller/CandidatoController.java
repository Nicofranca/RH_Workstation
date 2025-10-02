package org.rhworkstation.controller;

import org.rhworkstation.service.CandidatoSevice;
import org.rhworkstation.service.CurriculoService;
import org.rhworkstation.view.Inputs;
import org.rhworkstation.view.Menus;

public class CandidatoController {
    Inputs inputs = new Inputs();
    CandidatoSevice candidatoSevice = new CandidatoSevice();
    CurriculoService curriculoService = new CurriculoService();
    Menus menus = new Menus();

        //Criar candidato - ListarVagas
        public void iniciar(){
            boolean saida = false;

            while (!saida){
                switch (menus.menuCandidato()){
                    case 1 -> candidatoSevice.listarVagas();
                    case 2 -> curriculoService.criarCurriculo();
                    case 3 -> curriculoService.editarCurriculo();
                    case 4 -> curriculoService.excluirCurriculo();
                    case 0 -> {
                        saida = true;
                        return;
                    }
                }
            }
        }
}
