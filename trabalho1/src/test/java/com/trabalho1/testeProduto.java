package com.trabalho1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class testeProduto {

    @Test
    public void testeCadastroProduto(){
        Produto produto = new Produto("001", "Notebook", 2000.00, "unidade");
        assertEquals("001", produto.getCodigo());
        assertEquals("Notebook", produto.getDescricao());
        assertEquals(2000.00, produto.getValorVenda(), 0.01);
        assertEquals("unidade", produto.getUnidade());
    }
    
}
