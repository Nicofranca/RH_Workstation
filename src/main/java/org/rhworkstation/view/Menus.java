package org.rhworkstation.view;

import static org.rhworkstation.utils.Utils.inputNumber;


import org.rhworkstation.service.*;

import java.sql.SQLException;

public class Menus {
    ColaboradorService colaboradorTeste = new ColaboradorService();
    CurriculoService curriculoService = new CurriculoService();

    public void mostrarMenu() throws SQLException {

        var candidatoTeste = new CandidatoService();
        // var colaboradorTeste = new ColaboradorService();
        // var adminTeste = new AdminService();
        var vagaFiltroTeste = new VagaFiltroService();

        // candidatoTeste.listarVagas();

        // adminTeste.criarColaborador();
        // adminTeste.editarColaborador();
        // adminTeste.desligarColaborador();
        // adminTeste.listarCandidatos();
        // adminTeste.criarVaga();
        // adminTeste.excluirVaga();
        // adminTeste.editarVaga();
        // adminTeste.excluirVaga();

        // curriculoService.excluirCurriculo();

        // vagaFiltroTeste.listarVagasPorCargo();
        vagaFiltroTeste.listarVagasPorFaixaSalarial();
    }


    public int menuInicial(){


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
        System.out.println("                    ┃ 0 - Logout                               ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");

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
        System.out.println("                    ┃ 0 - Logout                               ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");


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
        System.out.println("                    ┃ 3 - Excluir Vagas                        ┃");
        System.out.println("                    ┃ 4 - Olhar Candidatos                     ┃");
        System.out.println("                    ┃                                          ┃");
        System.out.println("                    ┃ 0 - Voltar                               ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");


        return inputNumber();
    }


    public int gerenciarColaborador(){

        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃      RH Administração(Colaborador)       ┃");
        System.out.println("                    ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("                    ┃                  opções                  ┃");
        System.out.println("                    ┣------------------------------------------┫");
        System.out.println("                    ┃ 1 - Criar Colaborador                    ┃");
        System.out.println("                    ┃ 2 - Editar infos. Colaborador            ┃");
        System.out.println("                    ┃ 3 - Desligar Colaborador                 ┃");
        System.out.println("                    ┃ 4 - Olhar Solicitação de Férias          ┃");
        System.out.println("                    ┃ 5 - Tornar Candidado um Colaborador      ┃");
        System.out.println("                    ┃                                          ┃");
        System.out.println("                    ┃ 0 - Voltar                               ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");

        return inputNumber();
    }


    public int menuColaborador(){

        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃            Colaborador Menu              ┃");
        System.out.println("                    ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("                    ┃                  opções                  ┃");
        System.out.println("                    ┣------------------------------------------┫");
        System.out.println("                    ┃ 1 - Visualizar Folha Salarial            ┃");
        System.out.println("                    ┃ 2 - Solicitar Férias                     ┃");
        System.out.println("                    ┃ 3 - Editar Perfil                        ┃");
        System.out.println("                    ┃                                          ┃");
        System.out.println("                    ┃ 0 - Logout                               ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");

        return inputNumber();
    }

    public void menuFinal(){
        System.out.println("                   ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                   ┃ Agradecemos por utilizar o RH-Workstation! ┃");
        System.out.print  ("                   ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
    }
}




