package br.com.igoroliveira.controller;

import br.com.igoroliveira.model.FinancialEvents;
import br.com.igoroliveira.model.Person;
import br.com.igoroliveira.model.ScoreData;
import br.com.igoroliveira.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    // Only the owner of the CPF can access their personal data, including list of debts
    @GetMapping("/user-data")
    public Person getPersonalData(Authentication principal){
        return mainService.getPersonalData(principal.getName());
    }

    /* Both the owner of the CPF and credit institutions have access to score data.
     * In this first mapping, the authenticated user can access their own score data
     */
    @GetMapping("/my-score-data")
    public ScoreData getScoreData(Authentication principal){
        return mainService.getScoreData(principal.getName());
    }

    /* In this second mapping, authenticated users with "SCORE_READ" authority can
     * access the score data associated with a CPF, should they wish to calculate
     * the score using a different method than the one provided below
     */
    @GetMapping("/score-data")
    @PreAuthorize("hasAuthority('SCORE_READ')")
    public ScoreData getScoreData(@RequestParam String cpf){
        return mainService.getScoreData(cpf);
    }

    /* Both the owner of the CPF and authorized users (e.g, credit institutions)
     * have access to a CPF score.
     * In this first mapping, the authenticated user can access their own score
     */
    @GetMapping("/my-score")
    public Integer getScore(Authentication principal){
        return mainService.getScore(principal.getName());
    }

    /* In this second mapping, authenticated users with "SCORE_READ" authority can
     * access the score associated with a CPF according to a built-in calculation
     */
    @GetMapping("/score")
    @PreAuthorize("hasAuthority('SCORE_READ')")
    public Integer getScore(@RequestParam String cpf){
        return mainService.getScore(cpf);
    }


    /*
     * The user has access to their financial history
     */
    @GetMapping("/my-financial-events")
    public FinancialEvents getFinancialEvents(Authentication principal){
        return mainService.getFinancialEvents(principal.getName());
    }


    /*
     * Authorized users (e.g, credit card issuers) can access
     * last financial events associated with a CPF
     */
    @PreAuthorize("hasAuthority('FINANCIAL_EVENTS_READ')")
    @GetMapping("/financial-events")
    public FinancialEvents getFinancialEvents(@RequestParam String cpf){
        return mainService.getFinancialEvents(cpf);
    }


}
