package br.com.igoroliveira.model;

import java.sql.Timestamp;

public class Query {

    private Timestamp date;

    // Boa Vista, SPC, etc
    private String bureau;

    // CPF or CNPJ of the querier
    private String querier;

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
