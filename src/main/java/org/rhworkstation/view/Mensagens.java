package org.rhworkstation.view;

public class Mensagens {
    public void numberError(){
        System.err.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.err.println("                    ┃ Você digitou um valor incorreto, tente um número ┃");
        System.err.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");

        return;
    }

    public void dataError(){
        System.err.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.err.println("                    ┃ Data inválida! Digite no formato dd/MM/yyyy. ┃");
        System.err.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
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
        System.out.println("\u001b[32m                    ┃          Vaga excluida com sucesso!          ┃\u001b[0m");
        System.out.print  ("\u001b[32m                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\u001b[0m");
    }

    public static void filtroVagasValor(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃       Filtro de Vagas por Valor da Hora          ┃");
        System.out.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    public static void naoHaVagasFaixaSalarial(){
        System.err.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.err.println("                    ┃       Não há vagas nessa faixa salarial          ┃");
        System.err.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    public static void naoHaVagasCargo(){
        System.err.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.err.println("                    ┃  Não há vagas nessa cadastradas para esse cargo! ┃");
        System.err.println("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    public static void main(String[] args) {
        vagaCriadaSucesso();
    }
}
