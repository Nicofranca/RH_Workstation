package org.rhworkstation.controller;

import org.rhworkstation.service.*;
import org.rhworkstation.view.Menus;

public class AdminController {
    Menus menus = new Menus();
    ColaboradorService colaborador = new ColaboradorService();
    CandidatoService candidato = new CandidatoService();
    VagaService vaga = new VagaService();
    AdminService adminService = new AdminService();
    SolicitacaoFeriasService solicitacaoFeriasService = new SolicitacaoFeriasService();

    public void iniciarMenuAdmin() {
        boolean saida = false;

        while (!saida) {
            switch (menus.menuAdmin()) {
                case 1 -> {
                    switch (menus.gerenciarVagas()) {
                        case 1 -> vaga.criarVaga();
                        case 2 -> vaga.editarVaga();
                        case 3 -> vaga.excluirVaga();
                        case 4 -> candidato.listarCandidatos();
                        case 0 -> {
                            return;
                        }
                    }
                }

                case 2 -> {
                    switch (menus.gerenciarColaborador()) {
                        case 1 -> colaborador.criarColaborador();
                        case 2 -> colaborador.editarColaborador();
                        case 3 -> colaborador.desligarColaborador();
                        case 4 -> solicitacaoFeriasService.listarSolicitacoes();
                        case 5 -> adminService.tornarColaborador();
                        case 0 -> {
                            return;
                        }
                    }
                }

                case 0 -> {
                    saida = true;
                    return;
                }
            }
        }
    }
}
