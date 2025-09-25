package org.rhworkstation.view;

import org.rhworkstation.service.CandidatoSevice;
import org.rhworkstation.service.ColaboradorService;

public class Menus {
    public void mostrarMenu(){
        var candidatoTeste = new CandidatoSevice();
        var colaboradorTeste = new ColaboradorService();

        colaboradorTeste.criarColaborador();
    }
}
