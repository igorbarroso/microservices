package br.com.igoroliveira.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    /**
     * Database identifier
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idPerson;

    @CPF
    @JsonIgnore
    @NonNull
    private String cpf;

    @NonNull
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address",referencedColumnName = "idAddress", nullable = false)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Asset> assetList;

    private String sourceOfIncome;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @NonNull
    public String getCpf() {
        return cpf;
    }

    public void setCpf(@NonNull String cpf) {
        this.cpf = cpf;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    public String getSourceOfIncome() {
        return sourceOfIncome;
    }

    public void setSourceOfIncome(String sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }
}
