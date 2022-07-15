package br.com.letscode.bank.conta;

public class SaldoInsuficienteException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Saldo Insuficiente";
    }
}
