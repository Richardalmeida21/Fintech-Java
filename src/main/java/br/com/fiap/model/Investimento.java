package br.com.fiap.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Investimento {
    private int codigoInvestimento;
    private int codigoUsuario;
    private double valor;
    private String tipoInvestimento;
    private LocalDate dataInvestimento; // Use LocalDate para armazenar a data

    public Investimento(int codigoInvestimento, int codigoUsuario, double valor, String tipoInvestimento, LocalDate dataInvestimento) {
        this.codigoInvestimento = codigoInvestimento;
        this.codigoUsuario = codigoUsuario;
        this.valor = valor;
        this.tipoInvestimento = tipoInvestimento;
        this.dataInvestimento = dataInvestimento;
    }

    // Getters
    public int getCodigoInvestimento() { return codigoInvestimento; }
    public int getCodigoUsuario() { return codigoUsuario; }
    public double getValor() { return valor; }
    public String getTipoInvestimento() { return tipoInvestimento; }
    public LocalDate getDataInvestimento() { return dataInvestimento; }

    // Setters
    public void setCodigoInvestimento(int codigoInvestimento) {
        this.codigoInvestimento = codigoInvestimento;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public void setDataInvestimento(LocalDate dataInvestimento) {
        this.dataInvestimento = dataInvestimento;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Código: " + codigoInvestimento +
                ", Usuário: " + codigoUsuario +
                ", Valor: R$ " + String.format("%.2f", valor) +
                ", Tipo: " + tipoInvestimento +
                ", Data: " + dataInvestimento.format(formatter);
    }
}
