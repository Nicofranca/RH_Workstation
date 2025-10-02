package org.rhworkstation.controller;

import org.rhworkstation.service.AdminService;
import org.rhworkstation.service.SolicitacaoFeriasService;
import org.rhworkstation.view.Menus;

public class AdminController {
    Menus menus = new Menus();
    AdminService adminService = new AdminService();
    SolicitacaoFeriasService solicitacaoFeriasService = new SolicitacaoFeriasService();

    public void iniciarMenuAdmin() {
        boolean saida = false;

        while (!saida) {
            switch (menus.menuAdmin()) {
                case 1 -> {
                    switch (menus.gerenciarVagas()) {
                        case 1 -> adminService.criarVaga();
                        case 2 -> adminService.editarVaga();
                        case 3 -> adminService.excluirVaga();
                        case 4 -> adminService.listarCandidatos();
                        case 0 -> {
                            return;
                        }
                    }
                }

                case 2 -> {
                    switch (menus.gerenciarColaborador()) {
                        case 1 -> adminService.criarColaborador();
                        case 2 -> adminService.editarColaborador();
                        case 3 -> adminService.desligarColaborador();
                        case 4 -> solicitacaoFeriasService.listarSolicitacoes();
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
