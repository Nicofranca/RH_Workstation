package org.rhworkstation.service;

import org.rhworkstation.dao.AdminDAO;
import org.rhworkstation.dao.CandidatoDAO;
import org.rhworkstation.dao.ColaboradorDAO;
import org.rhworkstation.dao.VagaDAO;
import org.rhworkstation.model.Admin;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.view.Inputs;
import org.rhworkstation.exception.RHException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    Scanner sc = new Scanner(System.in);
    Inputs input = new Inputs();

    public boolean loginAdmin(String email, String senha){
        boolean adminEncontrado = false;
        var adminDAO = new AdminDAO();

        try {
            Admin admin = adminDAO.verificacaoAdmin(email, senha);
            if (admin != null){
                adminEncontrado = true;
                System.out.println("Login bem-sucedido! Bem-vindo(a) admin, "+admin.getNome());
            }

        } catch (RHException e){
            System.out.println("Erro ao realizar login: " + e.getMessage());
            e.printStackTrace();
        }

        return adminEncontrado;
    }

    public void tornarColaborador(){
        var adminDAO = new AdminDAO();
        var candidatoDAO = new CandidatoDAO();
        var candidato = new Candidato();

        String cpf = input.inputCpf();

        try {
            candidato = adminDAO.buscarPorCPF(cpf);
        } catch (RHException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Candidato encontrado: " + candidato.getCpf() + " - " + candidato.getNome() + " - " + candidato.getEmail());

        System.out.println("Deseja tornar este candidato um colaborador?(s/n)");
        String escolha = sc.nextLine();

        if (escolha.equalsIgnoreCase("s")){
            String cargo = input.inputCargo();
            String departamento= input.inputDepartamento();
            double salarioHora = input.inputSalarioHora();
            double horasDeTrabalho = input.inputHorasDeTrabalho();

            var colaborador = new Colaborador(candidato.getNome(), candidato.getCpf(), candidato.getEmail(), cargo, departamento, salarioHora, candidato.getSenha(), horasDeTrabalho);

            try {
                adminDAO.tornarColaborador(colaborador);
            } catch (RHException e) {
                throw new RuntimeException(e);
            }
        } else{
            return;
        }
    }

}