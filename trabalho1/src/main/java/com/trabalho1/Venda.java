package com.trabalho1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Venda {

    private Cliente cliente;
    private List<Produto> produtos;
    private FormaPagamento formaPagamento;
    private FormaPagamento formaCashback;
    private double valorTotal;
    private double desconto;
    private double frete;
    private double icms;
    private double impostoMunicipal;
    private String dataHora;
    private double cashback_cnt;
    double valor_cashback;

    public Venda(Cliente cliente, List<Produto> produtos, FormaPagamento formaPagamento, String cartao, FormaPagamento formaCashback, LocalDateTime dataHora){
        this.cliente = cliente;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
        this.formaCashback = formaCashback;
        this.valorTotal = calcularValorTotal(cartao);
        this.desconto = calcularDesconto(cartao);
        this.frete = calcularFrete();
        this.icms = calcularICMS();
        this.impostoMunicipal = calcularImpostoMunicipal();
        this.dataHora = dataHoraFormatter(dataHora);
        this.cashback_cnt = 0;
    }

    public Venda(Cliente cliente, List<Produto> produtos, FormaPagamento formaPagamento, String cartao, LocalDateTime dataHora){
        this.cliente = cliente;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
        this.formaCashback = FormaPagamento.NAO_CASHBACK;
        this.valorTotal = calcularValorTotal(cartao);
        this.desconto = calcularDesconto(cartao);
        this.frete = calcularFrete();
        this.icms = calcularICMS();
        this.impostoMunicipal = calcularImpostoMunicipal();
        this.dataHora = dataHoraFormatter(dataHora);
        this.cashback_cnt = 0;
    }

    public Venda(Cliente cliente, List<Produto> produtos, FormaPagamento formaPagamento, FormaPagamento formaCashback, LocalDateTime dataHora){
        this.cliente = cliente;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
        this.formaCashback = formaCashback;
        this.valorTotal = calcularValorTotal("0000 0000 0000 0000");
        this.desconto = calcularDesconto("0000 0000 0000 0000");
        this.frete = calcularFrete();
        this.icms = calcularICMS();
        this.impostoMunicipal = calcularImpostoMunicipal();
        this.dataHora = dataHoraFormatter(dataHora);
        this.cashback_cnt = 0;
    }

    public Venda(Cliente cliente, List<Produto> produtos, FormaPagamento formaPagamento, LocalDateTime dataHora){
        this.cliente = cliente;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
        this.formaCashback = FormaPagamento.NAO_CASHBACK;
        this.valorTotal = calcularValorTotal("0000 0000 0000 0000");
        this.desconto = calcularDesconto("0000 0000 0000 0000");
        this.frete = calcularFrete();
        this.icms = calcularICMS();
        this.impostoMunicipal = calcularImpostoMunicipal();
        this.dataHora = dataHoraFormatter(dataHora);
        this.cashback_cnt = 0;
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

    public FormaPagamento getFormaCashback() {
        return formaCashback;
    }

    public void setFormaCashback(FormaPagamento formaCashback) {
        this.formaCashback = formaCashback;
    }

    public double getCashback_cnt() {
        return cashback_cnt;
    }

    public void setCashback_cnt(double cashback_cnt) {
        this.cashback_cnt = cashback_cnt;
    }

    private double calcularValorTotal(String cartao) {
        double valorTotal_1 = valorReal() + calcularICMS() + calcularImpostoMunicipal();
        double cashback_2 = this.cliente.getSaldoCashBack();
        
        //Trecho de código alterado para extração de método (begin)
        /*
         * Foram feitos dois métodos novos calculoCash que calcula o cashback do cliente 
         * e o método CalculoCasheDesconto que calcula o valor total com os descontes e o 
         * cashback aplicado, ao qual é retonado pelo método calcularValorTotal.
         */
        
        return calculoCashEDesco(valorTotal_1, cashback_2, cartao);
        
        // (end)
    }

    // Métodos criados para satisfazer a condição de Extrair Método (begin)
    private double calculoCashEDesco(double valorTotal_1, double cashback_2, String cartao)
    {
        valorTotal_1 += calcularFrete();
        valorTotal_1 = Math.round(valorTotal_1 * 100.0) / 100.0;
        if (valorTotal_1 < calcularDesconto(cartao)) {
            cashback_2 = (calcularDesconto(cartao) - valorTotal_1);
            this.cliente.setSaldoCashBack(cashback_2);
            return 0.0;
        } else { 
            cashback_2 = calculoCash(((int) ((valorTotal_1 - calcularDesconto(cartao)) * 100)) / 100.0, cashback_2, cartao);
            this.cliente.setSaldoCashBack(cashback_2);
            return ((int) ((valorTotal_1 - calcularDesconto(cartao)) * 100)) / 100.0;
        }
    }

    private double calculoCash(double valor_total, double cashback_2, String cartao)
    {
        if (this.cliente.getTipoCliente() == TipoCliente.PRIME && getFormaCashback() == FormaPagamento.NAO_CASHBACK)
            return cashback_2 + calcularCashback(cartao, valor_total);
        else
            return calcularCashback(cartao, valor_total);
    }
    //(end)

    // Método subistituído por objeto-método: (begin)
    private double calcularDesconto(String cartao) {

        //continuei com esses comando pois a refatoração seria mais trabalhosa do que manter-lás.
        if (getCashback_cnt() == 0) valor_cashback = this.cliente.getSaldoCashBack();
        
        setCashback_cnt(1);
        //(end)

        //Adicionei o objeto-método que retorna o valor total a ser descontado do valor total da venda.
        return new CalculoDescontoVenda(getCliente(), valorReal() + calcularICMS() + calcularImpostoMunicipal(), valor_cashback, formaPagamento, formaCashback, verificarCartaoLoja(cartao)).calculoDesconto();
    }
    // (end)

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

    private double calcularCashback(String cartao, double valorTotal) {
        double cashback_1 = 0.0;
        if (this.cliente.getTipoCliente() == TipoCliente.PRIME)
        {
            if (verificarCartaoLoja(cartao)) cashback_1 = valorTotal * 0.05;
            else cashback_1 = valorTotal * 0.03;
        }

        cashback_1 = Math.round(cashback_1*100.0)/100.0;

        return ((int)((cashback_1)*100))/100.0;
    }

    

}
