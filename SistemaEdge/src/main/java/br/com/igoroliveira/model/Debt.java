package br.com.igoroliveira.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Debt {
    private int idDebt;

    private Date expirationDate;

    private BigDecimal currentValue;

    private String contractId;

    private boolean discountAvailable;

    private BigDecimal discountValue;

    private boolean paid;

    private Creditor creditor;

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
