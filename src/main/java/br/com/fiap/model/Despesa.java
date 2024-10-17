package br.com.fiap.model;

import java.time.LocalDate;

public class Despesa {
    private int codigoDespesa;
    private int codigoUsuario;
    private double valor;
    private LocalDate dataDespesa; // Alterado para LocalDate
    private int codigoCategoria;

    // Construtor
    public Despesa(int codigoDespesa, int codigoUsuario, double valor, LocalDate dataDespesa, int codigoCategoria) {
        this.codigoDespesa = codigoDespesa;
        this.codigoUsuario = codigoUsuario;
        this.valor = valor;
        this.dataDespesa = dataDespesa;
        this.codigoCategoria = codigoCategoria;
    }

    // Getters e Setters
    public int getCodigoDespesa() { return codigoDespesa; }
    public int getCodigoUsuario() { return codigoUsuario; }
    public double getValor() { return valor; }
    public LocalDate getDataDespesa() { return dataDespesa; }
    public int getCodigoCategoria() { return codigoCategoria; }

    @Override
    public String toString() {
        return "Despesa{" +
                "codigoDespesa=" + codigoDespesa +
                ", codigoUsuario=" + codigoUsuario +
                ", valor=" + valor +
                ", dataDespesa=" + dataDespesa +
                ", codigoCategoria=" + codigoCategoria +
                '}';
    }
}
