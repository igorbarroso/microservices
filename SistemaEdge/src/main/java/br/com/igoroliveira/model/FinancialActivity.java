package br.com.igoroliveira.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class FinancialActivity {

    // Loan, mortgage, purchase, etc.
    private String type;

    private Timestamp date;

    private BigDecimal value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
