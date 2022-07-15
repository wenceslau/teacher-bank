package br.com.letscode.bank.conta;

import java.math.BigDecimal;

public interface Conta {

    BigDecimal sacar(BigDecimal valor);

    BigDecimal depositar(BigDecimal valor);

    BigDecimal transferencia(BigDecimal valor, Conta recebedora);

    String consultaSaldo();
}
