package br.com.letscode.bank.conta;

import br.com.letscode.bank.cliente.Cliente;

import java.math.BigDecimal;

public class ContaInvestimento extends ContaDefault {

    public ContaInvestimento(Cliente cliente) {
        super(cliente);
    }

    public BigDecimal investir(BigDecimal valor){
        BigDecimal taxaRendimento = new BigDecimal(1.02);
        return super.depositar(valor.multiply(taxaRendimento));
    }

    @Override
    public BigDecimal getSaldo() {
        return super.getSaldo();
    }
}
