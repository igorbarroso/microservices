package br.com.igoroliveira.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Debt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idDebt;

    private Date expirationDate;

    @NonNull
    private BigDecimal currentValue;

    private String contractId;

    @NonNull
    private boolean discountAvailable;

    private BigDecimal discountValue;

    private boolean paid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creditor",referencedColumnName = "idCreditor")
    private Creditor creditor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ower",referencedColumnName = "idPerson")
    private Person ower;

    public int getIdDebt() {
        return idDebt;
    }

    public void setIdDebt(int idDebt) {
        this.idDebt = idDebt;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public boolean isDiscountAvailable() {
        return discountAvailable;
    }

    public void setDiscountAvailable(boolean discountAvailable) {
        this.discountAvailable = discountAvailable;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    public Person getOwer() {
        return ower;
    }

    public void setOwer(Person ower) {
        this.ower = ower;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
