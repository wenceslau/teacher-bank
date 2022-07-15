package br.com.letscode.bank.cliente;

import java.time.LocalDate;

public class ClientePJ extends Cliente {

    private String cnpj;
    private LocalDate dataAbertura;
    private String razaoSocial;

    @Override
    public String getNome() {
        return razaoSocial;
    }

    @Override
    public void setNome(String nome) {
        razaoSocial = nome;
    }

    @Override
    public String getDocumento() {
        return cnpj;
    }

    @Override
    public void setDocumento(String documento) {
        this.cnpj = documento;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
