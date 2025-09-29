package org.rhworkstation.service;

import org.rhworkstation.dao.AdminDAO;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.model.Vaga;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;
import java.util.List;

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

    public void editarColaborador() {
        int id = input.inputID();
        input.limparScanner();
        String nome = input.inputNome();
        String cpf = input.inputCpf();
        String email = input.inputEmail();
        String cargo = input.inputCargo();
        String departamento = input.inputDepartamento();
        double salarioHora = input.inputSalarioHora();
        input.limparScanner();
        String senha = input.inputSenha();

        var colaborador = new Colaborador(id, nome, cpf, email, cargo, departamento, salarioHora, senha);
        var adminDAO = new AdminDAO();

        try {
            adminDAO.editarColaborador(colaborador);
            System.out.println("Colaborador atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar colaborador no banco de dados!");
            e.printStackTrace();
        }
    }

    public void desligarColaborador() {
        int id = input.inputID();

        var adminDAO = new AdminDAO();

        try {
            adminDAO.desligarColaborador(id);
            System.out.println("Colaborador desligado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao desligar colaborador no banco de dados!");
            e.printStackTrace();
        }
    }

    public void listarCandidatos() {
        try {
            List<Candidato> candidatos = AdminDAO.listarCandidatos();

            if (candidatos.isEmpty()) {
                System.out.println("Não há candidatos cadastrados.");
                return;
            }

            System.out.println("=== Lista de Candidatos ===");
            for (Candidato candidato : candidatos) {
                System.out.println("ID: " + candidato.getId());
                System.out.println("Nome: " + candidato.getNome());
                System.out.println("Cpf: " + candidato.getCpf());
                System.out.println("Email: " + candidato.getEmail());
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarVaga() {
        String nomeVaga = input.inputNomeVaga();
        String descricao = input.inputDescricaoVaga();
        double salarioHora = input.inputSalarioHoraVaga();

        Vaga vaga = new Vaga(nomeVaga, descricao, salarioHora);

        try {
            AdminDAO.criarVaga(vaga);
            System.out.println("Vaga criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar vaga no banco de dados!");
            e.printStackTrace();
        }
    }

    public void excluirVaga() {
        int id = input.inputID();

        try {
            AdminDAO.excluirVaga(id);
            System.out.println("Vaga excluída com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir vaga no banco de dados!");
            e.printStackTrace();
        }
    }

    public void editarVaga() {
        int id = input.inputID();
        input.limparScanner();
        String nomeVaga = input.inputNomeVaga();
        String descricao = input.inputDescricaoVaga();
        double salarioHora = input.inputSalarioHoraVaga();

        Vaga vaga = new Vaga(nomeVaga, descricao, salarioHora);
        vaga.setId(id);

        try {
            AdminDAO.editarVaga(vaga);
            System.out.println("Vaga atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar a vaga no banco de dados!");
            e.printStackTrace();
        }
    }

}