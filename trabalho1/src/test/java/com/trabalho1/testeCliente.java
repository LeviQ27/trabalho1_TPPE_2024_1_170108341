package com.trabalho1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class testeCliente {

    @Test
    public void testeCadastroClientePadrao(){
        Endereco endereco_1 = new Endereco("MG", true);
        Cliente cliente_1 = new Cliente("André", TipoCliente.PADRAO, endereco_1);
        assertEquals(TipoCliente.PADRAO, cliente_1.getTipoCliente());
    }

}