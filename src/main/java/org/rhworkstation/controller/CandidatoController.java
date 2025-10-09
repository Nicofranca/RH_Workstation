package org.rhworkstation.controller;

import org.rhworkstation.service.CandidatoService;
import org.rhworkstation.service.CurriculoService;
import org.rhworkstation.service.VagaService;
import org.rhworkstation.view.Inputs;
import org.rhworkstation.view.Menus;

public class CandidatoController {
    Inputs inputs = new Inputs();
    CandidatoService candidatoSevice = new CandidatoService();
    CurriculoService curriculoService = new CurriculoService();
    VagaService vagaService = new VagaService();
    Menus menus = new Menus();

        //Criar candidato - ListarVagas
        public void iniciarMenuCandidato(){
            boolean saida = false;

            while (!saida){
                switch (menus.menuCandidato()){
                    case 1 -> vagaService.listarVagas();
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

        public void criarCandidato(){
            candidatoSevice.criarUsuario();
        }
}
