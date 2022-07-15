package br.com.letscode.bank.conta;

import br.com.letscode.bank.cliente.Cliente;
import br.com.letscode.bank.cliente.ClientePJ;

public class ContaPoupanca extends ContaDefault {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        if (getCliente() instanceof ClientePJ){
            throw new IllegalArgumentException("Clientes PJ não podem abrir conta poupança");
        }
    }
}
