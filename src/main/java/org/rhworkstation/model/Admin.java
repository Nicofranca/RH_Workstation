package org.rhworkstation.model;

import java.time.LocalDateTime;

public class Admin {

    private int id;
    private String nome;
    private String emai;
    private String senha;
    private LocalDateTime ultimo_login;

    public Admin() {}

    public Admin(int id, String nome, String emai, String senha, LocalDateTime ultimo_login) {
        this.id = id;
        this.nome = nome;
        this.emai = emai;
        this.senha = senha;
        this.ultimo_login = ultimo_login;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmai() {
        return emai;
    }
    public void setEmai(String emai) {
        this.emai = emai;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getUltimo_login() {
        return ultimo_login;
    }
    public void setUltimo_login(LocalDateTime ultimo_login) {
        this.ultimo_login = ultimo_login;
    }

}