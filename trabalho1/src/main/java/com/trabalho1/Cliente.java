package com.trabalho1;


public class Cliente {

    private String nome;
    private Endereco endereco;
    private TipoCliente tipoCliente;
    // Atributo que foi adicionado após refatoração: (begin)
    private CalculoCliente calculoCliente;
    // (end)

    

    public Cliente(String nome, TipoCliente tipoCliente, Endereco endereco){
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCliente = tipoCliente;
        this.calculoCliente = new CalculoCliente(0.0, 0.0, 0.0);
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

    // Alterações nos getters and setters para adequar a inserção de uma nova classe na classe Cliente. (begin)
    public double getComprasMensais() {
        return this.calculoCliente.getComprasMensais();
    }

    public void setComprasMensais(double comprasMensais) {
        this.calculoCliente.setComprasMensais(comprasMensais);
        atualizarTipoCliente();
    }

    public double getSaldoCashBack() {
        return this.calculoCliente.getSaldoCashBack();
    }

    public void setSaldoCashBack(double saldoCashBack) {
        this.calculoCliente.setSaldoCashBack(saldoCashBack);
    }

    public double getMensalidade() {
        return this.calculoCliente.getMensalidade();
    }

    public void setMensalidade(double mensalidade) {
        this.calculoCliente.setMensalidade(mensalidade);
        atualizarTipoCliente();
    }

    public CalculoCliente getCalculoCliente() {
        return calculoCliente;
    }

    public void setCalculoCliente(CalculoCliente calculoCliente) {
        this.calculoCliente = calculoCliente;
    }
    //(end)

    //método que foi refatorado: (begin)
    private void atualizarTipoCliente() {
        setTipoCliente(this.calculoCliente.atualizar(getTipoCliente()));
    }
    // (end)

    

}
