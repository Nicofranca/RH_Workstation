package org.rhworkstation.view;

import static java.awt.SystemColor.menu;
import static org.rhworkstation.utils.Utils.inputNumber;

import org.rhworkstation.service.AdminService;
import org.rhworkstation.service.CandidatoSevice;
import org.rhworkstation.service.ColaboradorService;
import org.rhworkstation.service.CurriculoService;

public class Menus {
    ColaboradorService colaboradorTeste = new ColaboradorService();
    CurriculoService curriculoService = new CurriculoService();


    public void mostrarMenu(){
        // var candidatoTeste = new CandidatoSevice();
        // var colaboradorTeste = new ColaboradorService();
        var adminTeste = new AdminService();

        // adminTeste.criarColaborador();
        // adminTeste.editarColaborador();
        // adminTeste.desligarColaborador();
        //adminTeste.listarCandidatos();

        curriculoService.editarCurriculo();
    }

    public static int menuInicial(){

        System.out.println("( ___ )-----------------------------------------------------------------------( ___ )\n" +
                " |   |  ____  _   _  __        __         _        _        _   _              |   | \n" +
                " |   | |  _ \\| | | | \\ \\      / /__  _ __| | _____| |_ __ _| |_(_) ___  _ __   |   | \n" +
                " |   | | |_) | |_| |  \\ \\ /\\ / / _ \\| '__| |/ / __| __/ _` | __| |/ _ \\| '_ \\  |   | \n" +
                " |   | |  _ <|  _  |   \\ V  V / (_) | |  |   <\\__ \\ || (_| | |_| | (_) | | | | |   | \n" +
                " |   | |_| \\_\\_| |_|    \\_/\\_/ \\___/|_|  |_|\\_\\___/\\__\\__,_|\\__|_|\\___/|_| |_| |   | \n" +
                " |___|                                                                         |___| \n" +
                "(_____)-----------------------------------------------------------------------(_____)");

        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃              SEJA BEM VINDO              ┃");
        System.out.println("                    ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("                    ┃                  opções                  ┃");
        System.out.println("                    ┣------------------------------------------┫");
        System.out.println("                    ┃ 1 - Candidatar-se                        ┃");
        System.out.println("                    ┃ 2 - Logar                                ┃");
        System.out.println("                    ┃                                          ┃");
        System.out.println("                    ┃ 0 - sair                                 ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");

        return inputNumber();

    }

    public int menuCandidato(){

        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃               Candidaturas               ┃");
        System.out.println("                    ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("                    ┃                  opções                  ┃");
        System.out.println("                    ┣------------------------------------------┫");
        System.out.println("                    ┃ 1 - Olhar Vagas                          ┃");
        System.out.println("                    ┃ 2 - Criar Currículo                      ┃");
        System.out.println("                    ┃ 3 - Editar Currículo                     ┃");
        System.out.println("                    ┃ 4 - Excluir Currículo                    ┃");
        /*System.out.println("                    ┃ 5 - Minhas Candidaturas                  ┃");*/
        System.out.println("                    ┃                                          ┃");
        System.out.println("                    ┃ 0 - sair                                 ┃");
        System.out.print("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");

        return inputNumber();
    }

    public int menuAdmin(){

        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃             RH Administração             ┃");
        System.out.println("                    ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("                    ┃                  opções                  ┃");
        System.out.println("                    ┣------------------------------------------┫");
        System.out.println("                    ┃ 1 - Gerenciar Vagas                      ┃");
        System.out.println("                    ┃ 2 - Gerenciar Colaborador                ┃");
        System.out.println("                    ┃                                          ┃");
        System.out.println("                    ┃ 0 - sair                                 ┃");
        System.out.print("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");

        return inputNumber();
    }

    public int gerenciarVagas(){

        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃   RH Administração(Processos Seletivos)  ┃");
        System.out.println("                    ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("                    ┃                  opções                  ┃");
        System.out.println("                    ┣------------------------------------------┫");
        System.out.println("                    ┃ 1 - Criar Vagas                          ┃");
        System.out.println("                    ┃ 2 - Editar Vagas                         ┃");
        System.out.println("                    ┃ 1 - Excluir Vagas                        ┃");
        System.out.println("                    ┃ 2 - Olhar Candidatos                     ┃");
        System.out.println("                    ┃                                          ┃");
        System.out.println("                    ┃ 0 - Voltar                               ┃");
        System.out.print("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");

        return inputNumber();
    }

}