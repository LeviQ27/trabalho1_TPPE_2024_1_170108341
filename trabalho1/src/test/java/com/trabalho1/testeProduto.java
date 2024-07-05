package com.trabalho1;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class testeProduto {

    String codigo;
    String descricao;
    double valorVenda;
    String unidade;

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] resposta = new  Object[][] {
            {"P001", "Notebook", 2000.00, "unidade"},
            {"P002", "Celular", 1200.00, "unidade"},
            {"P003", "Fone Bluetooth", 45.00, "peça"},
            {"P004", "Fita métrica", 20.00, "metro"}
        };
        return Arrays.asList(resposta);
    }

    public testeProduto(String codigo, String descricao, double valorVenda, String unidade){
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.unidade = unidade;
    }

    @Test
    public void testeCadastroProduto(){
        Produto produto = new Produto(codigo, descricao, valorVenda, unidade);
        assertEquals(codigo, produto.getCodigo());
        assertEquals(descricao, produto.getDescricao());
        assertEquals(valorVenda, produto.getValorVenda(), 0.01);
        assertEquals(unidade, produto.getUnidade());
    }
    
}
