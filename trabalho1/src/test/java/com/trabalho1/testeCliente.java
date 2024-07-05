package com.trabalho1;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class testeCliente {

    String nome;
    TipoCliente tipoClienteInicial;
    Endereco endereco;
    double comprasMensais;
    TipoCliente tipoClienteEsperado;

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] resposta = new Object[][] {
            {"João", TipoCliente.PADRAO, new Endereco("DF", true), 50.0, TipoCliente.PADRAO},
            {"André", TipoCliente.PADRAO, new Endereco("SP",false), 150.0, TipoCliente.ESPECIAL},
            {"Maria", TipoCliente.ESPECIAL, new Endereco("MG",true), 200.0, TipoCliente.ESPECIAL},
            {"Ana", TipoCliente.PRIME, new Endereco("RJ", true), 0.0, TipoCliente.PRIME}
        };
        return Arrays.asList(resposta);
    }

    public testeCliente(String nome, TipoCliente tipoClienteInicial, Endereco endereco, double comprasMensais, TipoCliente tipoClienteEsperado)
    {
        this.nome = nome;
        this.tipoClienteInicial = tipoClienteInicial;
        this.endereco = endereco;
        this.comprasMensais = comprasMensais;
        this.tipoClienteEsperado = tipoClienteEsperado;
    }

    @Test
    public void testeCadastroCliente(){
        Cliente cliente = new Cliente(nome, tipoClienteInicial, endereco);
        cliente.setComprasMensais(comprasMensais);
        assertEquals(tipoClienteEsperado, cliente.getTipoCliente());
    }

}