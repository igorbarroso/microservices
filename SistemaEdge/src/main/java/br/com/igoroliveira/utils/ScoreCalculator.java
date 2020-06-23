package br.com.igoroliveira.utils;

import br.com.igoroliveira.model.ScoreData;

import java.util.Objects;

public class ScoreCalculator {

    // Random implementation for score calculation
    public int calculateScore(ScoreData data){
        return (Objects.hash(data.getAddress(),data.getAge(),data.getAssetList(),data.getSourceOfIncome()))%1001;
    }
}
