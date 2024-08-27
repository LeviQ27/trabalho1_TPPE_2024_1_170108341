package com.trabalho1;

/*
 * Classe criada a partir da operação de refatoração de substituição do método por um 
 * objeto-método, em que recebe a informações de cliente, valor de cashback, valor da 
 * venda com icms + imposto municipal, as formas de pagamentos e cashback e um boleano 
 * que verificou o cartão, e retorna para classe Venda o desconto total.
 */
public class CalculoDescontoVenda {
    
    private Cliente cliente;
    private double valor_real;
    private double valor_cashback;
    private FormaPagamento formaPagamento;
    private FormaPagamento formaCashback;
    private boolean cartaoVerifica;

    public CalculoDescontoVenda(Cliente cliente, double valor_real, double valor_cashback, FormaPagamento formaPagamento, FormaPagamento formaCashback, boolean cartaoVerifica)
    {
        this.cliente = cliente;
        this.valor_real = valor_real;
        this.valor_cashback = valor_cashback;
        this.formaPagamento = formaPagamento;
        this.formaCashback = formaCashback;
        this.cartaoVerifica = cartaoVerifica;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public double getValor_real() {
        return valor_real;
    }
    public void setValor_real(double valor_real) {
        this.valor_real = valor_real;
    }
    public double getValor_cashback() {
        return valor_cashback;
    }
    public void setValor_cashback(double valor_cashback) {
        this.valor_cashback = valor_cashback;
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
    public boolean isCartaoVerifica() {
        return cartaoVerifica;
    }
    public void setCartaoVerifica(boolean cartaoVerifica) {
        this.cartaoVerifica = cartaoVerifica;
    }

    public double calculoDesconto()
    {
        double desconto;
        desconto = verificaCliente(getCliente(), getValor_real());
        desconto += verificaCarta(getValor_real(), getFormaPagamento(), isCartaoVerifica());
        return CalculoTotalDesconto(getCliente(), formaCashback, getValor_cashback(), desconto);
    }

    private double CalculoTotalDesconto(Cliente cliente2, FormaPagamento formaCashback2, double valor_cashback2, double desconto) {
        return cliente2.getTipoCliente() == TipoCliente.PRIME && formaCashback2 == FormaPagamento.SIM_CASHBACK ? desconto + valor_cashback2 : desconto;
    }

    private double verificaCarta(double valor_real2, FormaPagamento formaPagamento2, boolean cartaoVerifica2) {
        return formaPagamento2 == FormaPagamento.CARTAO_CREDITO && cartaoVerifica2 ? valor_real2*0.10 : 0.0;
    }

    private double verificaCliente(Cliente cliente, double valor_real2) {
        return cliente.getTipoCliente() == TipoCliente.ESPECIAL ? valor_real2*0.10 : 0.0;
    }


}
