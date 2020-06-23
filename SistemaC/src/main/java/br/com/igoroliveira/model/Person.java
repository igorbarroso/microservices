package br.com.igoroliveira.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idPerson;

    @NonNull
    @CPF
    @JsonIgnore
    private String cpf;

    @OneToOne
    @JoinColumn(name = "lastQuery",referencedColumnName = "idQuery")
    private Query lastQuery;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "person")
    private List<FinancialActivity> financialActivityList;

    @OneToOne
    @JoinColumn(name = "lastTransaction",referencedColumnName = "idCreditCardTransaction")
    private CreditCardTransaction lastTransaction;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @NonNull
    public String getCpf() {
        return cpf;
    }

    public void setCpf(@NonNull String cpf) {
        this.cpf = cpf;
    }

    public Query getLastQuery() {
        return lastQuery;
    }

    public void setLastQuery(Query lastQuery) {
        this.lastQuery = lastQuery;
    }

    public List<FinancialActivity> getFinancialActivityList() {
        return financialActivityList;
    }

    public void setFinancialActivityList(List<FinancialActivity> financialActivityList) {
        this.financialActivityList = financialActivityList;
    }

    public CreditCardTransaction getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(CreditCardTransaction lastTransaction) {
        this.lastTransaction = lastTransaction;
    }
}
