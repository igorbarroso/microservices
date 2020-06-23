package br.com.igoroliveira.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idPerson;

    @CPF
    @Column(unique = true)
    @NotNull
    private String cpf;


    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address",referencedColumnName = "idAddress", nullable = false)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ower")
    private List<Debt> debtList;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Debt> getDebtList() {
        return debtList;
    }

    public void setDebtList(List<Debt> debtList) {
        this.debtList = debtList;
    }
}
