package com.trabalho1;


public class Cliente {

    private String nome;
    private Endereco endereco;
    private TipoCliente tipoCliente;
    private double comprasMensais;
    private double saldoCashBack;
    private double mensalidade;

    public Cliente(String nome, TipoCliente tipoCliente, Endereco endereco){
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCliente = tipoCliente;
        this.comprasMensais = 0.0;
        this.saldoCashBack = 0.0;
        this.mensalidade = 0.0;
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
        atualizarTipoCliente();
    }

    public double getSaldoCashBack() {
        return saldoCashBack;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
        atualizarTipoCliente();
    }

    public void setSaldoCashBack(double saldoCashBack) {
        this.saldoCashBack = saldoCashBack;
    }

    private void atualizarTipoCliente() {
        if (this.comprasMensais > 100.00 && this.tipoCliente == TipoCliente.PADRAO) {
            this.tipoCliente = TipoCliente.ESPECIAL;
        }
        else if (this.comprasMensais < 100.00 && this.tipoCliente == TipoCliente.ESPECIAL && this.tipoCliente != TipoCliente.PRIME && this.mensalidade < 20.00) this.tipoCliente = TipoCliente.PADRAO;
        else if (this.mensalidade >= 20.00 && this.tipoCliente != TipoCliente.PRIME) this.tipoCliente = TipoCliente.PRIME;
        else if (this.mensalidade < 20.00 && this.tipoCliente == TipoCliente.PRIME) this.tipoCliente = TipoCliente.ESPECIAL;
    }

    

}
