package br.com.fiap.model;

import java.time.LocalDate;

public class Receita {
    private int codigoReceita;
    private int codigoUsuario;
    private double valor;
    private LocalDate dataReceita; // Alterado para LocalDate
    private int codigoCategoria;

    // Construtor
    public Receita(int codigoReceita, int codigoUsuario, double valor, LocalDate dataReceita, int codigoCategoria) {
        this.codigoReceita = codigoReceita;
        this.codigoUsuario = codigoUsuario;
        this.valor = valor;
        this.dataReceita = dataReceita;
        this.codigoCategoria = codigoCategoria;
    }

    // Getters e Setters
    public int getCodigoReceita() { return codigoReceita; }
    public int getCodigoUsuario() { return codigoUsuario; }
    public double getValor() { return valor; }
    public LocalDate getDataReceita() { return dataReceita; }
    public int getCodigoCategoria() { return codigoCategoria; }

    @Override
    public String toString() {
        return "Receita{" +
                "codigoReceita=" + codigoReceita +
                ", codigoUsuario=" + codigoUsuario +
                ", valor=" + valor +
                ", dataReceita=" + dataReceita +
                ", codigoCategoria=" + codigoCategoria +
                '}';
    }
}
