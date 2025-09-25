package org.rhworkstation.service;

import org.rhworkstation.dao.CandidatoDAO;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.view.Inputs;

import java.sql.SQLException;

public class CandidatoSevice {

    Inputs data = new Inputs();

    public void criarUsuario(){

        String nome = data.inputNome();
        String cpf = data.inputCpf();
        String email = data.inputEmail();
        String senha = data.inputSenha();

        var novoCandidato = new Candidato(nome, cpf, email, senha);
        var candidatoDAO = new CandidatoDAO();

        try {
            candidatoDAO.criarCandidato(novoCandidato);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
