package br.com.letscode.bank;

import br.com.letscode.bank.cliente.Cliente;
import br.com.letscode.bank.cliente.ClientePF;
import br.com.letscode.bank.cliente.ClientePJ;
import br.com.letscode.bank.conta.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {

        List<Conta> list = new ArrayList<>();
        Banco banco = new Banco(list);

        final var cliente = new ClientePF();
        cliente.setDocumento("00011122299");
        cliente.setNome("Ana Maria");
        cliente.setDataNascimento(LocalDate.of(1990,12,27));

        Conta contaCorrentePF = banco.abrirConta(cliente, TipoConta.CONTA_CORRENTE);
        System.out.println(contaCorrentePF.depositar(new BigDecimal(100)));
        try {
            System.out.println(contaCorrentePF.sacar(new BigDecimal(105)));
        }catch (SaldoInsuficienteException siex){
            System.err.println("Erro ao sacar: " + siex.getMessage());
        }

        final var clientePj =new ClientePJ();

        try {
            Conta contaPoupanca = banco.abrirConta(clientePj, TipoConta.CONTA_POUPANCA);
        } catch (Exception ex){
            System.err.println("Erro ao abrir conta: " + ex.getMessage());
        }

        ContaInvestimento contaInvestimento;
        Conta contaInv = banco.abrirConta(clientePj, TipoConta.CONTA_INVESTIMENTO);
        if (contaInv instanceof ContaInvestimento){
            contaInvestimento = (ContaInvestimento) contaInv;
            contaInvestimento.investir(new BigDecimal(100));
        }


////        BigDecimal num1 = BigDecimal.TEN;
////        //System.out.println(num1);
////        BigDecimal num2 = BigDecimal.ONE;
////        //System.out.println(num2);
////
////        System.out.println("O num1 é Maior num2 " + ( num1.compareTo(num2) > 0 ));
//
//
//        BigDecimal taxaRendimento = new BigDecimal(1.10);
//        BigDecimal saldo = new BigDecimal(150);
//        System.out.println(saldo.multiply(taxaRendimento));

    }
}
