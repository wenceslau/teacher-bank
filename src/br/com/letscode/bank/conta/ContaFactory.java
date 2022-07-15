package br.com.letscode.bank.conta;

import br.com.letscode.bank.cliente.Cliente;
import br.com.letscode.bank.cliente.ClientePJ;

public class ContaFactory {

    private ContaFactory() {
    }

    public static Conta criar(Cliente cliente, TipoConta tipoConta){

        switch (tipoConta){
            case CONTA_CORRENTE:
                return new ContaCorrente(cliente);
            case CONTA_POUPANCA:
                return new ContaPoupanca(cliente);
            case CONTA_INVESTIMENTO:
                return new ContaInvestimento(cliente);
            default:
                throw new IllegalArgumentException("Conta Invalida");
        }
    }
}
