package org.rhworkstation.view;

import org.rhworkstation.service.CandidatoSevice;
import org.rhworkstation.service.ColaboradorService;
import org.rhworkstation.service.CurriculoService;
import org.rhworkstation.service.VagaService;

public class Menus {
    public void mostrarMenu(){
        var candidatoTeste = new CandidatoSevice();
        var colaboradorTeste = new ColaboradorService();
        var curriculoTeste = new CurriculoService();
        var vagaTeste = new VagaService();

        //candidatoTeste.criarUsuario();
        //colaboradorTeste.criarColaborador();
        curriculoTeste.criarCurriculo();
    }
}
