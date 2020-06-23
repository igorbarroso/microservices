package br.com.igoroliveira.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class CreditCardTransaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idCreditCardTransaction;

    private BigDecimal value;

    private Timestamp date;

    private int numberOfInstallments;

    private String seller;

    public int getIdCreditCardTransaction() {
        return idCreditCardTransaction;
    }

    public void setIdCreditCardTransaction(int idCreditCardTransaction) {
        this.idCreditCardTransaction = idCreditCardTransaction;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
