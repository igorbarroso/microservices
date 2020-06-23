package br.com.igoroliveira.service;

import br.com.igoroliveira.model.FinancialEvents;
import br.com.igoroliveira.model.Person;
import br.com.igoroliveira.model.ScoreData;
import br.com.igoroliveira.utils.ScoreCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ScoreCalculator scoreCalculator;

    public Person getPersonalData(String cpf) {
        return restTemplate.getForObject("http://SistemaA/personal-data/" + cpf, Person.class);
    }

    public ScoreData getScoreData(String cpf) {
        return restTemplate.getForObject("http://SistemaB/score-data/" + cpf, ScoreData.class);
    }

    public FinancialEvents getFinancialEvents(String cpf) {
        return restTemplate.getForObject("http://SistemaC/financial-events/" + cpf, FinancialEvents.class);
    }

    public int getScore(String cpf) {
        ScoreData data = getScoreData(cpf);
        return scoreCalculator.calculateScore(data);
    }
}
