package com.trabalho1;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TesteCliente {

    String nome;
    TipoCliente tipoClienteInicial;
    Endereco endereco;
    double comprasMensais;
    double mensalidade;
    TipoCliente tipoClienteEsperado;

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] resposta = new Object[][] {
            {"João", TipoCliente.PADRAO, new Endereco("DF", true), 50.0, 0.0, TipoCliente.PADRAO},
            {"André", TipoCliente.PADRAO, new Endereco("SP",false), 150.0, 0.0, TipoCliente.ESPECIAL},
            {"Maria", TipoCliente.ESPECIAL, new Endereco("MG",true), 200.0, 0.0, TipoCliente.ESPECIAL},
            {"Ana", TipoCliente.PRIME, new Endereco("RJ", true), 0.0, 20.00, TipoCliente.PRIME},
            {"Analice", TipoCliente.PADRAO, new Endereco("RJ", true), 0.0, 20.00, TipoCliente.PRIME},
            {"Ana Clara", TipoCliente.ESPECIAL, new Endereco("RJ", true), 0.0, 20.00, TipoCliente.PRIME},
            {"Júlia", TipoCliente.ESPECIAL, new Endereco("RJ", true), 0.0, 0.0, TipoCliente.PADRAO},
            {"Vitória", TipoCliente.PRIME, new Endereco("RJ", true), 0.0, 0.0, TipoCliente.PADRAO},
        };
        return Arrays.asList(resposta);
    }

    public TesteCliente(String nome, TipoCliente tipoClienteInicial, Endereco endereco, double comprasMensais, double mensalidade, TipoCliente tipoClienteEsperado)
    {
        this.nome = nome;
        this.tipoClienteInicial = tipoClienteInicial;
        this.endereco = endereco;
        this.comprasMensais = comprasMensais;
        this.mensalidade = mensalidade;
        this.tipoClienteEsperado = tipoClienteEsperado;
    }

    @Test
    public void testeCadastroCliente(){
        Cliente cliente = new Cliente(nome, tipoClienteInicial, endereco);
        cliente.setComprasMensais(comprasMensais);
        cliente.setMensalidade(mensalidade);
        assertEquals(tipoClienteEsperado, cliente.getTipoCliente());
    }

}