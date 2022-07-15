package br.com.letscode.bank.cliente;

import java.time.LocalDate;

public class ClientePF extends Cliente {

    private String cpf = "";

    private LocalDate dataNascimento;

    @Override
    public String getDocumento() {
        return cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})","$1.$2.$3-$4");
    }

    @Override
    public void setDocumento(String documento) {
        //
        this.cpf = documento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
