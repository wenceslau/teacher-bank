package br.com.letscode.bank;

import br.com.letscode.bank.cliente.Cliente;
import br.com.letscode.bank.conta.Conta;
import br.com.letscode.bank.conta.ContaFactory;
import br.com.letscode.bank.conta.TipoConta;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private final List<Conta> contas;

    public Banco(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Conta abrirConta(Cliente cliente, TipoConta tipoConta){
        Conta conta = ContaFactory.criar(cliente, tipoConta);
        contas.add(conta);
        return conta;
    }
}
