package org.rhworkstation.service;

import org.rhworkstation.dao.AdminDAO;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;

public class AdminService {

    Inputs input = new Inputs();

    public void criarColaborador() {
        String nome = input.inputNome();
        String cpf = input.inputCpf();
        String email = input.inputEmail();
        String senha = input.inputSenha();
        String cargo = input.inputCargo();
        String departamento = input.inputDepartamento();
        double salarioHora = input.inputSalarioHora();


        var colaborador = new Colaborador(nome, cpf, email, cargo, departamento, salarioHora, senha);
        var adminDAO = new AdminDAO();

        try {
            adminDAO.criarColaborador(colaborador);
            System.out.println("Colaborador inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir colaborador no banco de dados!");
        }
    }

}