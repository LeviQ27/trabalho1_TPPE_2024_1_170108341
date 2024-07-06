package com.trabalho1;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class testeVenda {

    @Test
    public void testeVendaClienteEspecial()
    {
        Cliente cliente = new Cliente("Júlia", TipoCliente.ESPECIAL, new Endereco("RJ", false));
        cliente.setComprasMensais(150.00);
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("001", "Notebook", 2000.00, "unidade"));

        Venda venda = new Venda(cliente, produtos, "4296 1354 9243 5194");

        assertEquals(1859.00, venda.getValorTotal(), 0.01);
        assertEquals(10.00, venda.getFrete(), 0.01);
    }
    
}
