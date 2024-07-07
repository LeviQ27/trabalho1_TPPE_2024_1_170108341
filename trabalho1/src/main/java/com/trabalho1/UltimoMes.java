package com.trabalho1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UltimoMes {
    private Cliente cliente;
    private List<Venda> vendas;
    private double saldoMes;

    public UltimoMes(Cliente cliente, List<Venda> vendas){
        this.cliente = cliente;
        this.vendas = vendas;
        this.saldoMes = calcularSaldoMes();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public double getSaldoMes() {
        return saldoMes;
    }

    public void setSaldoMes(double saldoMes) {
        this.saldoMes = saldoMes;
    }

    private double calcularSaldoMes() {
        double total = this.cliente.getComprasMensais();
        int day = 6;
        int month = 7;
        int dif_month;
        for (Venda x : vendas){
            int[] numbers = extrairNumeros(x.getDataHora());
            dif_month = Math.abs(month - numbers[1]);
            if (numbers[0] <= day && dif_month < 1) total += x.getValorTotal();
            else if (numbers[0] >= day && dif_month == 1) total += x.getValorTotal();
            System.out.println(this.cliente.getSaldoCashBack());
        }

        this.cliente.setComprasMensais(total);


        return total;
    }

    public static int[] extrairNumeros(String str) {
        // Expressão regular para encontrar números de até dois dígitos
        Pattern pattern = Pattern.compile("\\b\\d{1,2}\\b");
        Matcher matcher = pattern.matcher(str);

        int[] numbers = new int[2];
        int count = 0;

        // Encontrar e armazenar os primeiros dois números de até dois dígitos como inteiros
        while (matcher.find() && count < 2) {
            String numberStr = matcher.group();
            int number = Integer.parseInt(numberStr);
            numbers[count] = number;
            count++;
            System.out.println(number);
        }

        // Retornar os números encontrados
        return numbers;
    }
}
