package com.trabalho1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class testeVenda {

    Cliente cliente;
    List<Produto> produtos;
    String cartao_credito;
    double valorTotalEsperado;
    double descontoEsperado;
    double freteEsperado;
    double icmsEsperado;
    double impostoMunicipalEsperado;

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] resposta = new Object[][] {
            {new Cliente("André", TipoCliente.PADRAO, new Endereco("TO", false)), Arrays.asList(new Produto("P001", "Notebook", 2000.00, "unidade"), new Produto("P002", "Fita Métrica", 25.00, "metro"), new Produto("P003", "Celular", 1256.92, "unidade")), "5623 1421 9432 2331", 3832.03, 0.0, 25.00, 393.83, 131.28},
            {new Cliente("Alice", TipoCliente.ESPECIAL, new Endereco("DF", true)), Arrays.asList(new Produto("P004", "Notebook Gamer", 6350.00, "unidade"), new Produto("P005", "Caneta Preta", 10.00, "unidade"), new Produto("P006", "Caixa de Cartões", 6.55, "unidade")), "5623 8411 6217 2962", 6762.78, 751.25, 1.50, 1145.98, 0.0},
            {new Cliente("Lucileia", TipoCliente.PRIME, new Endereco("BA", false)), Arrays.asList(new Produto("P007", "Geladeira", 7523.20, "unidade"), new Produto("P002", "Fita Métrica", 25.00, "metro"), new Produto("P008", "Torneira", 56.92, "peça")), "4296 1321 9432 2331", 7939.74, 882.19, 0.0, 912.61, 304.21},
            {new Cliente("Pedro", TipoCliente.ESPECIAL, new Endereco("MG", true)), Arrays.asList(new Produto("P001", "Notebook", 2000.00, "unidade"), new Produto("P002", "Fita Métrica", 25.00, "metro"), new Produto("P003", "Celular", 1256.92, "unidade")), "4296 1334 8543 1229", 3047.72, 761.41, 2.10, 393.83, 131.28}
        };
        return Arrays.asList(resposta);
    }

    public testeVenda(Cliente cliente, List<Produto> produtos, String cartao_credito, double valorTotalEsperado, double descontoEsperado, double freteEsperado, double icmsEsperado, double impostoMunicipalEsperado){
        this.cliente = cliente;
        this.produtos = produtos;
        this.cartao_credito = cartao_credito;
        this.valorTotalEsperado = valorTotalEsperado;
        this.descontoEsperado = descontoEsperado;
        this.freteEsperado = freteEsperado;
        this.icmsEsperado = icmsEsperado;
        this.impostoMunicipalEsperado = impostoMunicipalEsperado;
    }

    @Test
    public void testeVendaCliente()
    {
        Venda venda = new Venda(cliente, produtos, cartao_credito);
        assertEquals(valorTotalEsperado, venda.getValorTotal(), 0.01);
        assertEquals(descontoEsperado, venda.getDesconto(), 0.01);
        assertEquals(freteEsperado, venda.getFrete(), 0.01);
        assertEquals(icmsEsperado, venda.getIcms(), 0.01);
        assertEquals(impostoMunicipalEsperado, venda.getImpostoMunicipal(), 0.01);
    }
    
}
