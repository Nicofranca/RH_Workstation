package org.rhworkstation.service;

import org.rhworkstation.dao.CandidatoDAO;
import org.rhworkstation.dao.CurriculoDAO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Curriculo;
import org.rhworkstation.utils.Utils;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;


public class CurriculoService {
    Utils utils = new Utils();
    Inputs data = new Inputs();

    public void criarCurriculo(){
        var candidatoDAO = new CandidatoDAO();
        int idCandidato = 0;

        String cpf = data.inputCpf();

        try {
            idCandidato = candidatoDAO.buscarPorCPF(cpf);
        } catch (RHException e) {
            throw new RuntimeException(e);
        }

        int idade = data.inputIdade();

        utils.limparScanner();

        String sexo = data.inputSexo();
        String formacao = data.inputFormacao();
        String texto = data.inputTexto();

        var curriculo = new Curriculo(idade, sexo, formacao, texto, idCandidato);
        var curriculoDAO = new CurriculoDAO();

        try {
            curriculoDAO.criarCurriculo(curriculo);

        } catch (RHException e) {
            System.out.println("Erro ao criar curriculo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void excluirCurriculo(){
        String cpf = data.inputCpf();

        var curriculoDAO = new CurriculoDAO();
        var candidatoDAO = new CandidatoDAO();

        try {
            curriculoDAO.exluirCurriculo(candidatoDAO.buscarPorCPF(cpf));

        } catch (RHException e) {
            System.out.println("Erro ao excluir curriculo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void mostrarID(){
        String cpf = data.inputCpf();

        var candidatoDAO = new CandidatoDAO();

        try {
            System.out.println(candidatoDAO.buscarPorCPF(cpf));

        } catch (RHException e) {
            System.out.println("Erro ao mostrar ID: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void editarCurriculo(){
        String cpf = data.inputCpf();

        int idade = data.inputIdade(); //        utils.limparScanner();


        String sexo = data.inputSexo();
        String formacao = data.inputFormacao();
        String texto = data.inputTexto();

        var curriculo = new Curriculo(idade, sexo , formacao, texto);
        var curriculoDAO = new CurriculoDAO();
        var candidatoDAO = new CandidatoDAO();

        try {
            int valorID = candidatoDAO.buscarPorCPF(cpf);

            curriculoDAO.editarCurriculo(curriculo, valorID);

        } catch (RHException e) {
            System.out.println("Erro ao editar curriculo: " + e.getMessage());
            e.printStackTrace();
        }
    }

}