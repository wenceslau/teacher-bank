package br.com.letscode.bank.conta;

import br.com.letscode.bank.cliente.Cliente;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class ContaDefault  implements Conta {

    private Cliente cliente;
    private BigDecimal saldo;

    public ContaDefault(Cliente cliente) {
        this.cliente = cliente;
        saldo = BigDecimal.ZERO;
    }

    @Override
    public BigDecimal sacar(BigDecimal valor) {
        //if (this.getSaldo().compareTo(valor) > 0){
        if (this.getSaldo().doubleValue() >= valor.doubleValue()){
            this.setSaldo(this.getSaldo().subtract(valor));
            return this.getSaldo();
        }
        throw new SaldoInsuficienteException();
    }

    @Override
    public BigDecimal depositar(BigDecimal valor) {
        this.setSaldo(this.getSaldo().add(valor));
        return this.getSaldo();
    }

    @Override
    public BigDecimal transferencia(BigDecimal valor, Conta recebedora) {
        //if (this.getSaldo().compareTo(valor) > 0){
        if (this.getSaldo().doubleValue() >= valor.doubleValue()){
            recebedora.depositar(valor);
            return this.sacar(valor);
        }
        throw new SaldoInsuficienteException();
    }

    @Override
    public String consultaSaldo() {
        return NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(getSaldo());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    private void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
