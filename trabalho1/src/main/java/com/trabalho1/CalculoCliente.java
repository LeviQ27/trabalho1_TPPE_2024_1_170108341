package com.trabalho1;

/*
 * Classe criada para  staisfazer a extração de classe 
 * na refatoação do código sugerido pelo professor.
 * Na classe é feito a inserção dos atributos 
 * comprasMensais, saldoCashBack e mensalidade antes 
 * feitos direto na classe Cliente. E foi feito o 
 * método atualizar que serve para atuallizar o tipo 
 * de cliente que era feito direto na classe Cliente.
 */
public class CalculoCliente {
    private double comprasMensais;
    private double saldoCashBack;
    private double mensalidade;

    

    public CalculoCliente(double comprasMensais, double saldoCashBack, double mensalidade)
    {
        this.comprasMensais = comprasMensais;
        this.saldoCashBack = saldoCashBack;
        this.mensalidade = mensalidade;
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

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public TipoCliente atualizar(TipoCliente tipoCliente)
    {
        if (this.comprasMensais > 100.00 && tipoCliente == TipoCliente.PADRAO) {
            return TipoCliente.ESPECIAL;
        } else if (this.comprasMensais < 100.00 && tipoCliente == TipoCliente.ESPECIAL
                && tipoCliente != TipoCliente.PRIME && this.mensalidade < 20.00)
            return TipoCliente.PADRAO;
        else if (this.mensalidade >= 20.00 && tipoCliente != TipoCliente.PRIME)
            return TipoCliente.PRIME;
        else if (this.mensalidade < 20.00 && tipoCliente == TipoCliente.PRIME)
            return TipoCliente.ESPECIAL;
        
        return tipoCliente;
    }
}
