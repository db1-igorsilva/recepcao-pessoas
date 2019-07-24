package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    protected Person() { }

    private Person(PersonBuilder builder) {
        name = builder.name;
        cpf = builder.cpf;
    }

    // BUILDER

    public static class PersonBuilder {

        private String name;
        private String cpf;

        public PersonBuilder personName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder personCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

    // GETTERS AND SETTERS

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
