package br.com.fiap.model;

import java.time.LocalDate;

public class Usuario {
    private int codigoUsuario;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataCriacao;

    public Usuario(int codigoUsuario, String nome, String email, String senha, LocalDate dataCriacao) {
        this.codigoUsuario = codigoUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
    public int getCodigoUsuario() { return codigoUsuario; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public LocalDate getDataCriacao() { return dataCriacao; }
}
