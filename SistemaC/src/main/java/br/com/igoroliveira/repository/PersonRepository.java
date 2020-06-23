package br.com.igoroliveira.repository;

import br.com.igoroliveira.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    Optional<Person> findByCpf(String cpf);
}
