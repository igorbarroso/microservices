package br.com.igoroliveira.model;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Creditor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idCreditor;

    @CNPJ
    @NonNull
    @Column(unique = true)
    private String cnpj;

    @NonNull
    private String legalName;

    public int getIdCreditor() {
        return idCreditor;
    }

    public void setIdCreditor(int idCreditor) {
        this.idCreditor = idCreditor;
    }

    @NonNull
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NonNull String cnpj) {
        this.cnpj = cnpj;
    }

    @NonNull
    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(@NonNull String legalName) {
        this.legalName = legalName;
    }
}
