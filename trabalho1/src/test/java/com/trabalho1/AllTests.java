package com.trabalho1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TesteCliente.class, TesteProduto.class, TesteVenda.class, TesteVendaCashback.class, TesteUltimasVendas.class})
public class AllTests {
    
}
