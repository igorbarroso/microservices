package br.com.igoroliveira.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class FinancialActivity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idFinancialActivity;

    // Loan, mortgage, purchase, etc.
    private String type;

    private Timestamp date;

    private BigDecimal value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person", referencedColumnName = "idPerson")
    private Person person;

    public int getIdFinancialActivity() {
        return idFinancialActivity;
    }

    public void setIdFinancialActivity(int idFinancialActivity) {
        this.idFinancialActivity = idFinancialActivity;
    }

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
