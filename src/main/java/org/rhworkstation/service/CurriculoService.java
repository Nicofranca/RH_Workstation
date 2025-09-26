package org.rhworkstation.service;

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
}
