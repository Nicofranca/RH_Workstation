package org.rhworkstation.utils;

import org.rhworkstation.view.Mensagens;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    static Mensagens mensagens = new Mensagens();
    static Scanner input = new Scanner(System.in);

    public static int inputNumber() {
        boolean error = true;
        int number = 0;

        do {
            try {
                number = input.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                mensagens.numberError();
                input.nextLine();
            }
        } while (error);
        return number;
    }

    public static void limparScanner(){
        input.nextLine();
    }
}