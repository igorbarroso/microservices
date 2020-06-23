package br.com.igoroliveira.model;

public class Creditor {

    private int idCreditor;

    private String cnpj;

    private String legalName;

    public int getIdCreditor() {
        return idCreditor;
    }

    public void setIdCreditor(int idCreditor) {
        this.idCreditor = idCreditor;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }
}
