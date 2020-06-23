package br.com.igoroliveira.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Query {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idQuery;

    private Timestamp date;

    // Serasa, Boa Vista, etc
    private String bureau;

    // CPF or CNPJ of the querier
    private String querier;

    public int getIdQuery() {
        return idQuery;
    }

    public void setIdQuery(int idQuery) {
        this.idQuery = idQuery;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getBureau() {
        return bureau;
    }

    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public String getQuerier() {
        return querier;
    }

    public void setQuerier(String querier) {
        this.querier = querier;
    }
}
