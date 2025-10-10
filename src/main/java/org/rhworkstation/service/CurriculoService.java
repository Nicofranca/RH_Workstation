package org.rhworkstation.service;

import org.rhworkstation.dao.CandidatoDAO;
import org.rhworkstation.dao.CurriculoDAO;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Curriculo;
import org.rhworkstation.utils.Utils;
import org.rhworkstation.view.Inputs;
import static org.rhworkstation.context.CacheContext.getCacheCpf;

public class CurriculoService {

    Utils utils = new Utils();
    Inputs data = new Inputs();

    public void criarCurriculo(){
        var candidatoDAO = new CandidatoDAO();
        var curriculoDAO = new CurriculoDAO();
        int idCandidato = 0;

        boolean verificar;

        try {
            verificar = curriculoDAO.verificarExistenciaCurriculo(getCacheCpf());
        } catch (RHException e) {
            throw new RuntimeException(e);
        }

        if (verificar == false){
            try {
                idCandidato = candidatoDAO.buscarPorCPF(getCacheCpf());

                if (idCandidato <= 0) {
                    System.err.println("Erro: Candidato com o CPF informado não foi encontrado.");
                    return;
                }

                System.out.println("Candidato encontrado. Por favor, complete os dados do currículo:");

            } catch (RHException e) {
                throw new RuntimeException(e);
            }

            int idade = data.inputIdade();

            utils.limparScanner();

            String sexo = data.inputSexo();
            String formacao = data.inputFormacao();
            String texto = data.inputTexto();

            var curriculo = new Curriculo(idade, sexo, formacao, texto, idCandidato);

            try {
                curriculoDAO.criarCurriculo(curriculo);

            } catch (RHException e) {
                System.err.println("                    Erro ao criar curriculo: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Você ja possui um curriculo!");
        }
    }

    public void excluirCurriculo(){
        var curriculoDAO = new CurriculoDAO();
        var candidatoDAO = new CandidatoDAO();

        try {
            curriculoDAO.excluirCurriculo(candidatoDAO.buscarPorCPF(getCacheCpf()));

        } catch (RHException e) {
            System.err.println("                    Erro ao excluir curriculo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void mostrarID(){
        String cpf = data.inputCpf();

        var candidatoDAO = new CandidatoDAO();

        try {
            System.out.println(candidatoDAO.buscarPorCPF(cpf));

        } catch (RHException e) {
            System.err.println("                    Erro ao mostrar ID: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void editarCurriculo(){
        int idade = data.inputIdade(); //        utils.limparScanner();


        String sexo = data.inputSexo();
        String formacao = data.inputFormacao();
        String texto = data.inputTexto();

        var curriculo = new Curriculo(idade, sexo , formacao, texto);
        var curriculoDAO = new CurriculoDAO();
        var candidatoDAO = new CandidatoDAO();

        try {
            int valorID = candidatoDAO.buscarPorCPF(getCacheCpf());

            curriculoDAO.editarCurriculo(curriculo, valorID);

        } catch (RHException e) {
            System.err.println("                    Erro ao editar curriculo: " + e.getMessage());
            e.printStackTrace();
        }
    }

}