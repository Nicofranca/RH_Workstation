package org.rhworkstation.view;

public class Mensagens {
    public void numberError(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ Você digitou um valor incorreto, tente um número ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");

        return;
    }

    public void dataError(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ Data inválida! Digite no formato dd/MM/yyyy. ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
    }

    public static void vagaCriadaSucesso(){
        System.out.println("\u001b[32m                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\u001b[0m");
        System.out.println("\u001b[32m                    ┃          Vaga criada com sucesso!            ┃\u001b[0m");
        System.out.print  ("\u001b[32m                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\u001b[0m");
    }

    public static void vagaExcluidaSucesso(){
        System.out.println("\u001b[32m                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\u001b[0m");
        System.out.println("\u001b[32m                    ┃          Vaga excluida com sucesso!          ┃\u001b[0m");
        System.out.print  ("\u001b[32m                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\u001b[0m");
    }

    public static void vagaEditadaSucesso(){
        System.out.println("\u001b[32m                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\u001b[0m");
        System.out.println("\u001b[32m                    ┃          Vaga editada com sucesso!           ┃\u001b[0m");
        System.out.print  ("\u001b[32m                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\u001b[0m");
    }

    public static void filtroVagasValor(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃       Filtro de Vagas por Valor da Hora          ┃");
        System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    public static void filtroVagasFaixaSalarial(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃        Filtro de Vagas por Faixa Salarial        ┃");
        System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    public static void filtroVagasCargo(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃            Filtro de Vagas por Cargo             ┃");
        System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    public static void naoHaVagasFaixaSalarial(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃       Não há vagas nessa faixa salarial          ┃");
        System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    public static void naoHaVagasCargo(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃  Não há vagas nessa cadastradas para esse cargo! ┃");
        System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    public static void main(String[] args) {
        vagaCriadaSucesso();
    }
}