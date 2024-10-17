package br.com.fiap.model;

public class Conta {
    private int codigoConta;
    private int codigoUsuario;
    private double saldo;
    private String tipoConta; // Novo atributo

    // Construtor
    public Conta(int codigoConta, int codigoUsuario, double saldo, String tipoConta) {
        this.codigoConta = codigoConta;
        this.codigoUsuario = codigoUsuario;
        this.saldo = saldo;
        this.tipoConta = tipoConta; // Inicializa o novo atributo
    }

    // Getters e Setters
    public int getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(int codigoConta) {
        this.codigoConta = codigoConta;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "codigoConta=" + codigoConta +
                ", codigoUsuario=" + codigoUsuario +
                ", saldo=" + saldo +
                ", tipoConta='" + tipoConta + '\'' +
                '}';
    }
}
