package org.rhworkstation.service;

import org.rhworkstation.dao.ColaboradorDAO;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;

public class ColaboradorService {

    Inputs input = new Inputs();

    public void editarColaborador() {
        int id = input.inputID();
        String nome = input.inputNome();
        String cpf = input.inputCpf();
        String email = input.inputEmail();
        String cargo = input.inputCargo();
        String departamento = input.inputDepartamento();
        double salarioHora = input.inputSalarioHora();
        String senha = input.inputSenha();

        var colaborador = new Colaborador(id, nome, cpf, email, cargo, departamento, salarioHora, senha);
        var colaboradorDAO = new ColaboradorDAO();

        try {
            colaboradorDAO.editarColaborador(colaborador);
            System.out.println("Colaborador atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar colaborador no banco de dados!");
            e.printStackTrace();
        }
    }

    public void desligarColaborador() {
        int id = input.inputID();

        var colaboradorDAO = new ColaboradorDAO();

        try {
            colaboradorDAO.desligarColaborador(id);
            System.out.println("Colaborador desligado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao desligar colaborador no banco de dados!");
            e.printStackTrace();
        }
    }

}