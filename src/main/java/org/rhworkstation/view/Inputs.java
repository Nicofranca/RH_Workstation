package org.rhworkstation.view;

import org.rhworkstation.model.enums.StatusVaga;
import org.rhworkstation.utils.Utils.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static org.rhworkstation.utils.Utils.inputNumber;


public class  Inputs {
    Scanner input = new Scanner(System.in);
    Mensagens mensagens = new Mensagens();



    public String inputNome(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Nome                          ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String nome = input.nextLine();

        return nome;
    }

    public int inputHorasDeTrabalho(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite as Horas de Trabalho            ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        return inputNumber();
    }

    public String inputCpf(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o CPF                           ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String cpf = input.nextLine();

        return cpf;
    }

    public String inputEmail(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o email                         ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String email = input.nextLine();

        return email;
    }

    public String inputSenha(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Senha                         ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String senha = input.nextLine();

        return senha;
    }
    public String inputCargo(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Cargo                         ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String cargo = input.nextLine();

        return cargo;
    }

    public String inputDepartamento(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Departamento                  ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String departamento = input.nextLine();

        return departamento;
    }

    public double inputSalarioHora(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Valor da Hora                 ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        double salarioHora = input.nextDouble();

        return salarioHora;
    }

    public int inputIdade(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite a Idade                         ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String stringIdade = input.nextLine();

        int idade = Integer.parseInt(stringIdade);

        return idade;
    }

    public String inputSexo(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Sexo                          ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String sexo = input.nextLine();

        return sexo;
    }

    public String inputFormacao(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite a Formação                      ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String formacao = input.nextLine();

        return formacao;
    }

    public String inputTexto(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o texto                         ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String texto = input.nextLine();

        return texto;
    }

    public String inputNomeVaga(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Nome da Vaga                  ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String nomeVaga = input.nextLine();

        return nomeVaga;
    }
    public String inputDescricaoVaga(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite a Descrição da Vaga             ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        String descricaoVaga = input.nextLine();

        return descricaoVaga;
    }

    public double inputSalarioHoraVaga(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Salario por Hora da Vaga      ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        double SalarioHoraVaga = input.nextDouble();

        return SalarioHoraVaga;
    }

    public StatusVaga status(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Status da Vaga                ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        StatusVaga status = StatusVaga.valueOf(input.next());

        return status;
    }

    public int inputID(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o ID                            ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        int id = input.nextInt();

        return id;
    }

    public Date inputDataInicio() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);

        Date dataInicio = null;

        while (dataInicio == null) {
            System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("                    ┃ - Digite a Data de Início                ┃");
            System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
            String linha = input.nextLine();

            try {
                dataInicio = formato.parse(linha);
            } catch (ParseException e) {
                mensagens.dataError();
            }
        }

        return dataInicio;

    }

    public Date inputDataFim() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);

        Date dataFim = null;

        while (dataFim == null) {
            System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("                    ┃ - Digite a Data de Fim                   ┃");
            System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
            String linha = input.nextLine();

            try {
                dataFim = formato.parse(linha);
            } catch (ParseException e) {
                mensagens.dataError();
            }
        }

        return dataFim;
    }

    public double inputSalarioHoraMinimo(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Valor da Hora Mínimo          ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        double salarioMin = input.nextDouble();

        return salarioMin;
    }

    public double inputSalarioHoraMaximo(){
        System.out.println("                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                    ┃ - Digite o Valor da Hora Máximo          ┃");
        System.out.print  ("                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n                    :");
        double salarioMax = input.nextDouble();

        return salarioMax;
    }

}