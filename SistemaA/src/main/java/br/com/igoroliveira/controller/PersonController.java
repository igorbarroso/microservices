package br.com.igoroliveira.controller;

import br.com.igoroliveira.model.Debt;
import br.com.igoroliveira.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import br.com.igoroliveira.service.PersonService;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/personal-data/{cpf}")
    public Person getPersonData(@PathVariable String cpf){
        return personService.findByCpf(cpf);
    }
}
