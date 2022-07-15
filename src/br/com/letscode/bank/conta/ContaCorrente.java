package br.com.letscode.bank.conta;

import br.com.letscode.bank.cliente.Cliente;
import br.com.letscode.bank.cliente.ClientePJ;

import java.math.BigDecimal;

public class ContaCorrente extends ContaDefault {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public BigDecimal sacar(BigDecimal valor) {
        if (getCliente() instanceof ClientePJ){
            return super.sacar(getValorAcrecidoDeTaxaExtra(valor));
        }
        return super.sacar(valor);
    }

    @Override
    public BigDecimal transferencia(BigDecimal valor, Conta recebedora) {
        if (getCliente() instanceof ClientePJ){
            return super.transferencia(getValorAcrecidoDeTaxaExtra(valor), recebedora);
        }
        return super.transferencia(valor, recebedora);
    }

    private BigDecimal getValorAcrecidoDeTaxaExtra(BigDecimal valor){
        BigDecimal taxaExtra = new BigDecimal(1.05); //1=100%, 0.1=10% 0.01=1%
        return valor.multiply(taxaExtra);
    }
}
