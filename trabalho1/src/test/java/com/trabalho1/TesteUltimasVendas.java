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
public class TesteUltimasVendas {

    Cliente cliente;
    List<Venda> vendas;
    double valorTotalEsperado;
    double cashback;
    TipoCliente tipoCliente;


    @Parameters
    public static Collection<Object[]> getParameters(){
        LocalDateTime dataHora_1 = LocalDateTime.of(2024, 5, 7, 14, 20, 12);
        LocalDateTime dataHora_2 = LocalDateTime.of(2024, 3, 7, 14, 20, 12);
        LocalDateTime dataHora_3 = LocalDateTime.of(2024, 3, 7, 14, 20, 12);
        LocalDateTime dataHora_4 = LocalDateTime.of(2024, 7, 2, 14, 20, 12);
        LocalDateTime dataHora_5 = LocalDateTime.of(2024, 3, 2, 14, 20, 12);
        LocalDateTime dataHora_6 = LocalDateTime.of(2024, 5, 2, 14, 20, 12);
        LocalDateTime dataHora_7 = LocalDateTime.of(2024, 6, 14, 14, 20, 12);
        Cliente cliente_1 = new Cliente("Alex", TipoCliente.PRIME, new Endereco("DF", true));
        Cliente cliente_2 = new Cliente("Julio", TipoCliente.ESPECIAL, new Endereco("SP", false));
        Cliente cliente_3 = new Cliente("Rafa", TipoCliente.PADRAO, new Endereco("BA", true));
        Cliente cliente_4 = new Cliente("Caio", TipoCliente.PRIME, new Endereco("SC", false));
        cliente_4.setMensalidade(20.00);
        cliente_4.setSaldoCashBack(35.00);
        Object[][] resposta = new Object[][] {
            {cliente_1, Arrays.asList(new Venda(cliente_1, Arrays.asList(new Produto("P001", "Notebook", 2000.00, "unidade"), new Produto("P002", "Fita Métrica", 25.00, "metro"), new Produto("P003", "Celular", 1256.92, "unidade"), new Produto("P004", "Notebook Gamer", 6350.00, "unidade"), new Produto("P005", "Caneta Preta", 10.00, "unidade"), new Produto("P006", "Caixa de Cartões", 6.55, "unidade")), FormaPagamento.CARTAO_CREDITO, "4296 1334 8543 1229", dataHora_1), new Venda(cliente_1, Arrays.asList(new Produto("P001", "Notebook", 2000.00, "unidade"), new Produto("P002", "Fita Métrica", 25.00, "metro"), new Produto("P003", "Celular", 1256.92, "unidade"), new Produto("P001", "Notebook", 2000.00, "unidade"), new Produto("P002", "Fita Métrica", 25.00, "metro"), new Produto("P003", "Celular", 1256.92, "unidade")), FormaPagamento.CARTAO_CREDITO, "4296 1334 8543 1229", dataHora_2), new Venda(cliente_1, Arrays.asList(new Produto("P007", "Geladeira", 7523.20, "unidade"), new Produto("P002", "Fita Métrica", 25.00, "metro"), new Produto("P008", "Torneira", 56.92, "peça"), new Produto("P004", "Notebook Gamer", 6350.00, "unidade"), new Produto("P005", "Caneta Preta", 10.00, "unidade"), new Produto("P006", "Caixa de Cartões", 6.55, "unidade")), FormaPagamento.CARTAO_CREDITO, "4296 1334 8543 1229", dataHora_3), new Venda(cliente_1, Arrays.asList(new Produto("P001", "Notebook", 2000.00, "unidade"), new Produto("P005", "Caneta Preta", 10.00, "unidade"), new Produto("P006", "Caixa de Cartões", 6.55, "unidade"), new Produto("P005", "Caneta Preta", 10.00, "unidade"), new Produto("P006", "Caixa de Cartões", 6.55, "unidade")), FormaPagamento.CARTAO_CREDITO, "4296 1334 8543 1229", dataHora_4)), 2159.15, 1710.72, TipoCliente.ESPECIAL},
            {cliente_2, Arrays.asList(new Venda(cliente_2, Arrays.asList(new Produto("P205", "Carregador Portátil", 235.23, "unidade"), new Produto("P422", "HotWheels Vectar", 12.00, "unidade")), FormaPagamento.CARTAO_CREDITO, "2345 0698 3424 0101", dataHora_5), new Venda(cliente_2, Arrays.asList(new Produto("P205", "Carregador Portátil", 235.23, "unidade"), new Produto("P422", "HotWheels Vectar", 12.00, "unidade")), FormaPagamento.CARTAO_CREDITO, "2345 0698 3424 0101", dataHora_6)), 0.0, 0.0, TipoCliente.PADRAO},
            {cliente_3, Arrays.asList(new Venda(cliente_3, Arrays.asList(new Produto("P205", "Carregador Portátil", 235.23, "unidade"), new Produto("P422", "HotWheels Vectar", 12.00, "unidade")), FormaPagamento.CARTAO_CREDITO, "2345 0698 3424 0101", dataHora_6), new Venda(cliente_3, Arrays.asList(new Produto("P205", "Fone Bluetooth", 50.23, "unidade"), new Produto("P422", "Secador", 62.00, "unidade")), FormaPagamento.CARTAO_CREDITO, "2345 0698 3424 0101", dataHora_7)), 145.19, 0.0, TipoCliente.ESPECIAL},
            {cliente_4, Arrays.asList(new Venda(cliente_4, Arrays.asList(new Produto("P205", "Fone Bluetooth", 50.23, "unidade"), new Produto("P422", "Secador", 62.00, "unidade")), FormaPagamento.PIX, FormaPagamento.SIM_CASHBACK, dataHora_7), new Venda(cliente_4, Arrays.asList(new Produto("P205", "Carregador Portátil", 235.23, "unidade"), new Produto("P422", "HotWheels Vectar", 12.00, "unidade")), FormaPagamento.CARTAO_CREDITO, "2345 0698 3424 0101", dataHora_5)), 95.19, 11.45, TipoCliente.PRIME},
        };
        return Arrays.asList(resposta);
    }

    public TesteUltimasVendas(Cliente cliente, List<Venda> vendas, double valorTotalEsperado, double cashback, TipoCliente tipoCliente){
        this.cliente = cliente;
        this.vendas = vendas;
        this.valorTotalEsperado = valorTotalEsperado;
        this.cashback = cashback;
        this.tipoCliente = tipoCliente;
    }

    @Test
    public void testeUltimoMes(){
        UltimoMes ultimoMes = new UltimoMes(cliente, vendas);
        assertEquals(valorTotalEsperado, ultimoMes.getSaldoMes(), 0.01);
        assertEquals(valorTotalEsperado, cliente.getComprasMensais(), 0.01);
        assertEquals(cashback, cliente.getSaldoCashBack(), 0.01);
        assertEquals(tipoCliente, cliente.getTipoCliente());
    }



    
}
