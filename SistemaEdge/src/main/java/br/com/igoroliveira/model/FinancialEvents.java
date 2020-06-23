package br.com.igoroliveira.model;

import java.util.List;
public class FinancialEvents {

    private Query lastQuery;

    private List<FinancialActivity> financialActivityList;

    private CreditCardTransaction lastTransaction;

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

