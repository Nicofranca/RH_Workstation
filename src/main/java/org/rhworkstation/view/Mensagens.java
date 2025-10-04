package org.rhworkstation.view;

public class Mensagens {
    public void numberError(){
        System.err.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.err.println("                    ┃ Você digitou um valor incorreto, tente um número ┃");
        System.err.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
    }

    public void dataError(){
        System.err.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.err.println("                    ┃ Data inválida! Digite no formato dd/MM/yyyy. ┃");
        System.err.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
    }
}
