package com.trabalho1;

import java.util.List;


public class Venda {

    private Cliente cliente;
    private List<Produto> produtos;
    private double valorTotal;
    private double desconto;
    private double frete;
    private double icms;
    private double impostoMunicipal;
    private String data;

    public Venda(Cliente cliente, List<Produto> produtos, String cartao){
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = calcularValorTotal(cartao);
        this.desconto = calcularDesconto(cartao);
        this.frete = calcularFrete();
        this.icms = calcularICMS();
        this.impostoMunicipal = calcularImpostoMunicipal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getIcms() {
        return icms;
    }

    public void setIcms(double icms) {
        this.icms = icms;
    }

    public double getImpostoMunicipal() {
        return impostoMunicipal;
    }

    public void setImpostoMunicipal(double impostoMunicipal) {
        this.impostoMunicipal = impostoMunicipal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private double calcularValorTotal(String cartao) {
        double valorTotal_1 = valorReal();
        switch (this.cliente.getTipoCliente()) {
            case ESPECIAL:
                valorTotal_1 += calcularFrete() * 0.3;
                break;
            case PRIME:
                break;
            default:
                valorTotal_1 += calcularFrete();
                break;
        }
        return valorTotal_1 -= calcularDesconto(cartao);
    }

    private double calcularDesconto(String cartao) {
        double desconto_1 = 0.0;
        if (this.cliente.getTipoCliente() == TipoCliente.ESPECIAL) {
            desconto_1 += valorReal() * 0.10;
        }


        if (this.cliente.getTipoCliente() == TipoCliente.ESPECIAL && verificarCartaoLoja(cartao))
        {
            desconto_1 += valorReal() * 0.10;
        }
        

        return desconto_1;
    }

    private double calcularFrete() {
        double frete_1 = 0.0;
        
        switch (this.cliente.getEndereco().getEstado()) {
            case "AC":
            case "AP":
            case "AM":
            case "PA":
            case "RO":
            case "RR":
            case "TO":
                if (this.cliente.getEndereco().iseCapital()) frete_1 = 20.00;
                else frete_1 = 25.00;
                break;
            case "AL":
            case "BA":
            case "CE":
            case "MA":
            case "PB":
            case "PE":
            case "PI":
            case "RN":
            case "SE":
                if (this.cliente.getEndereco().iseCapital()) frete_1 = 15.00;
                else frete_1 = 18.00;
                break;
            case "GO":
            case "MT":
            case "MS":
                if (this.cliente.getEndereco().iseCapital()) frete_1 = 10.00;
                else frete_1 = 13.00;
                break;
            case "ES":
            case "MG":
            case "RJ":
            case "SP":
                if (this.cliente.getEndereco().iseCapital()) frete_1 = 7.00;
                else frete_1 = 10.00;
                break;
            case "PR":
            case "RS":
            case "SC":
                if (this.cliente.getEndereco().iseCapital()) frete_1 = 10.00;
                else frete_1 = 13.00;
                break;
            default:
                if (this.cliente.getEndereco().iseCapital()) frete_1 = 5.00;
                break;
        }
        
        return frete_1;
    }

    private double calcularICMS() {
        return this.cliente.getEndereco().getEstado().equals("DF") ? 0.18 : 0.12;
    }

    private double calcularImpostoMunicipal() {
        return this.cliente.getEndereco().getEstado().equals("DF") ? 0 : 0.04;
    }

    private  double valorReal()
    {
        double valorReal = (produtos.stream().mapToDouble(Produto::getValorVenda).sum() * calcularImpostoMunicipal()) + (produtos.stream().mapToDouble(Produto::getValorVenda).sum() * calcularICMS()) + (produtos.stream().mapToDouble(Produto::getValorVenda).sum());

        
        return valorReal;
    }

    private boolean verificarCartaoLoja(String cartao){
        String texto = "4296 13";
        char caractere, caractere_2;

        for (int i = 0; i < texto.length(); i++) {
            caractere = texto.charAt(i);
            caractere_2 = cartao.charAt(i);
            if (caractere != caractere_2) return false;
        }

        return true;
    }


}
