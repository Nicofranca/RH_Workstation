package org.rhworkstation.dao;

import org.rhworkstation.connection.Conexao;
import org.rhworkstation.exception.RHException;
import org.rhworkstation.model.Admin;
import org.rhworkstation.model.Candidato;
import org.rhworkstation.model.Colaborador;
import org.rhworkstation.model.Vaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public Admin verificacaoAdmin(String email, String senha) throws RHException{
        String query = "SELECT id, nome, email, ultimo_login, senha FROM administrador WHERE email = ? AND senha = ?";
        Admin admin = null;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    admin = new Admin();
                    admin.setId(rs.getInt("id"));
                    admin.setEmail(rs.getString("email"));
                    admin.setNome(rs.getString("nome"));
                    admin.setSenha(rs.getString("senha"));

                    if (rs.getTimestamp("ultimo_login") != null){
                        admin.setUltimo_login(rs.getTimestamp("ultimo_login").toLocalDateTime());
                    }
                }
            }

        } catch (SQLException e) {
            throw new RHException("Erro ao verificar admin", e);
        }

        return admin;
    }

    public void tornarColaborador() throws RHException{
        String query = "INSERT";
    }

}