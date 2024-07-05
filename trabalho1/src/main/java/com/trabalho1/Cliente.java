package com.trabalho1;


public class Cliente {

    private String nome;
    private Endereco endereco;
    private TipoCliente tipoCliente;
    private double comprasMensais;
    private double saldoCashBack;

    public Cliente(String nome, TipoCliente tipoCliente, Endereco endereco){
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCliente = tipoCliente;
        this.comprasMensais = 0.0;
        this.saldoCashBack = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public double getComprasMensais() {
        return comprasMensais;
    }

    public void setComprasMensais(double comprasMensais) {
        this.comprasMensais = comprasMensais;
    }

    public double getSaldoCashBack() {
        return saldoCashBack;
    }

    public void setSaldoCashBack(double saldoCashBack) {
        this.saldoCashBack = saldoCashBack;
    }


}
