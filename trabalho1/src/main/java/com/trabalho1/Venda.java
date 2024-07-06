package com.trabalho1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Venda {

    private Cliente cliente;
    private List<Produto> produtos;
    private FormaPagamento formaPagamento;
    private double valorTotal;
    private double desconto;
    private double frete;
    private double icms;
    private double impostoMunicipal;
    private String dataHora;

    public Venda(Cliente cliente, List<Produto> produtos, FormaPagamento formaPagamento, String cartao, LocalDateTime dataHora){
        this.cliente = cliente;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
        this.valorTotal = calcularValorTotal(cartao);
        this.desconto = calcularDesconto(cartao);
        this.frete = calcularFrete();
        this.icms = calcularICMS();
        this.impostoMunicipal = calcularImpostoMunicipal();
        this.dataHora = dataHoraFormatter(dataHora);
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

     public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    private double calcularValorTotal(String cartao) {
        double valorTotal_1 = valorReal() + calcularICMS() + calcularImpostoMunicipal();
        valorTotal_1 += calcularFrete();
        valorTotal_1 = Math.round(valorTotal_1*100.0)/100.0;

        return ((int)((valorTotal_1 - calcularDesconto(cartao))*100))/100.0;
    }

    private double calcularDesconto(String cartao) {
        double desconto_1 = 0.0;
        double valorReal_2 = valorReal() + calcularICMS() + calcularImpostoMunicipal();

        if (this.cliente.getTipoCliente() == TipoCliente.ESPECIAL) {
            desconto_1 += valorReal_2 * 0.10;
        }


        if (verificarCartaoLoja(cartao) && this.formaPagamento == FormaPagamento.CARTAO_CREDITO)
        {
            desconto_1 += valorReal_2 * 0.10;
        }
        

        return desconto_1;
    }

    private double calcularFrete() {
        double frete_1 = 0.0;
        
        if (this.cliente.getTipoCliente() != TipoCliente.PRIME)
        {
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
                    frete_1 += 5.00;
                    break;
            }
        }
        
        
        return this.cliente.getTipoCliente() == TipoCliente.ESPECIAL ? frete_1 * 0.3 : frete_1;
    }

    private double calcularICMS() {
        return this.cliente.getEndereco().getEstado().equals("DF") ? valorReal() * 0.18 : valorReal() * 0.12;
    }

    private double calcularImpostoMunicipal() {
        return this.cliente.getEndereco().getEstado().equals("DF") ? 0 : valorReal() * 0.04;
    }

    private double valorReal()
    {
        return produtos.stream().mapToDouble(Produto::getValorVenda).sum();
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

    private String dataHoraFormatter(LocalDateTime dataHora) {
        String padrao = "dd/MM/yyyy HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(padrao);
        return dataHora.format(formatter);
    }

}
