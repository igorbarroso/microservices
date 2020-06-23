package br.com.igoroliveira.service;

import br.com.igoroliveira.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.igoroliveira.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findByCpf(String cpf) {
        return personRepository.findByCpf(cpf).orElseThrow(() -> new NoSuchElementException("CPF não encontrado"));
    }

}
