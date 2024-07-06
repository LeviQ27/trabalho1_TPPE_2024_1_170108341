package com.trabalho1;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class testeVendaCashback {

    Cliente cliente;
    List<Produto> produtos;
    FormaPagamento formaPagamento;
    String cartao_credito;
    FormaPagamento formaCashback;
    LocalDateTime dataHora;
    double valorTotalEsperado;
    double descontoEsperado;
    double cashbackEsperado;

    @Parameters
    public static Collection<Object[]> getParameters(){
        Cliente cliente_1 = new Cliente("André", TipoCliente.PRIME, new Endereco("TO", false));
        cliente_1.setSaldoCashBack(345.00);
        Cliente cliente_2 = new Cliente("Alice", TipoCliente.PRIME, new Endereco("DF", true));
        cliente_2.setSaldoCashBack(1452.00);
        Cliente cliente_3 = new Cliente("Lucileia", TipoCliente.PRIME, new Endereco("BA", false));
        cliente_3.setSaldoCashBack(560.00);
        Cliente cliente_4 = new Cliente("Pedro", TipoCliente.PRIME, new Endereco("MG", true));
        cliente_4.setSaldoCashBack(5000.00);
        Object[][] resposta = new Object[][] {
            {cliente_1, Arrays.asList(new Produto("P001", "Notebook", 2000.00, "unidade"), new Produto("P002", "Fita Métrica", 25.00, "metro"), new Produto("P003", "Celular", 1256.92, "unidade")), FormaPagamento.CARTAO_CREDITO, "5623 1421 9432 2331", FormaPagamento.SIM_CASHBACK,"2024-05-07T14:23:45", 3462.03, 345.0, 103.86},
            {cliente_2, Arrays.asList(new Produto("P004", "Notebook Gamer", 6350.00, "unidade"), new Produto("P005", "Caneta Preta", 10.00, "unidade"), new Produto("P006", "Caixa de Cartões", 6.55, "unidade")), FormaPagamento.CARTAO_CREDITO, "5623 8411 6217 2962", FormaPagamento.NAO_CASHBACK, "2024-05-10T09:52:10", 7512.53, 0.0, 1677.38},
            {cliente_3, Arrays.asList(new Produto("P007", "Geladeira", 7523.20, "unidade"), new Produto("P002", "Fita Métrica", 25.00, "metro"), new Produto("P008", "Torneira", 56.92, "peça")), FormaPagamento.CARTAO_CREDITO, "4296 1321 9432 2331", FormaPagamento.SIM_CASHBACK, "2024-05-10T21:00:45", 7379.74, 1442.19, 368.99},
            {cliente_4, Arrays.asList(new Produto("P001", "Notebook", 2000.00, "unidade"), new Produto("P002", "Fita Métrica", 25.00, "metro"), new Produto("P003", "Celular", 1256.92, "unidade")), FormaPagamento.CARTAO_CREDITO, "4296 1334 8543 1229", FormaPagamento.SIM_CASHBACK, "2024-05-17T10:13:15", 0.0, 5380.70, 1573.68}
        };
        return Arrays.asList(resposta);
    }

    public testeVendaCashback(Cliente cliente, List<Produto> produtos, FormaPagamento formaPagamento, String cartao_credito, FormaPagamento formaCashback, String dataHora, double valorTotalEsperado, double descontoEsperado, double cashbackEsperado){
        this.cliente = cliente;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
        this.cartao_credito = cartao_credito;
        this.formaCashback = formaCashback;
        this.dataHora = LocalDateTime.parse(dataHora);
        this.valorTotalEsperado = valorTotalEsperado;
        this.descontoEsperado = descontoEsperado;
        this.cashbackEsperado = cashbackEsperado;
    }

    @Test
    public void testeVendaCliente()
    {
        Venda venda = new Venda(cliente, produtos, formaPagamento, cartao_credito, formaCashback, dataHora);
        assertEquals(valorTotalEsperado, venda.getValorTotal(), 0.01);
        assertEquals(descontoEsperado, venda.getDesconto(), 0.01);
        assertEquals(cashbackEsperado, venda.getCliente().getSaldoCashBack(), 0.01);
    }
    
}
