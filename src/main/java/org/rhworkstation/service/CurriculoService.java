package org.rhworkstation.service;

import org.rhworkstation.dao.CandidatoDAO;
import org.rhworkstation.dao.CurriculoDAO;
import org.rhworkstation.model.Curriculo;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;

public class CurriculoService {
    Inputs data = new Inputs();

    public void criarCurriculo(){
        int idade = data.inputIdade();

        data.limparScanner();

        String sexo = data.inputSexo();
        String formacao = data.inputFormacao();
        String texto = data.inputTexto();

        var curriculo = new Curriculo(idade, sexo, formacao, texto);
        var curriculoDAO = new CurriculoDAO();

        try {
            curriculoDAO.criarCurriculo(curriculo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCurriculo(){
        String cpf = data.inputCpf();

        var curriculoDAO = new CurriculoDAO();
        var candidatoDAO = new CandidatoDAO();

        try {
            curriculoDAO.exluirCurriculo(candidatoDAO.buscarPorCPF(cpf));
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void mostrarID(){
        String cpf = data.inputCpf();

        var curriculoDAO = new CurriculoDAO();
        var candidatoDAO = new CandidatoDAO();

        try {
            System.out.println(candidatoDAO.buscarPorCPF(cpf));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarCurriculo(){
        String cpf = data.inputCpf();
        int idade = data.inputIdade();

        data.limparScanner();

        String sexo = data.inputSexo();
        String formacao = data.inputFormacao();
        String texto = data.inputTexto();

        var curriculo = new Curriculo(idade, sexo , formacao, texto);
        var curriculoDAO = new CurriculoDAO();
        var candidatoDAO = new CandidatoDAO();


        try {
            int valorID = candidatoDAO.buscarPorCPF(cpf);

            curriculoDAO.editarCurriculo(curriculo, valorID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
