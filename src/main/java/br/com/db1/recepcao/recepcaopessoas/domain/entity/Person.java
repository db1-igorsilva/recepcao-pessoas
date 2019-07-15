package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    protected Person() { }

    private Person(PersonBuilder builder) {
        id = UUID.randomUUID();
        name = builder.name;
        cpf = builder.cpf;
        birthDate = builder.birthDate;
    }

    // BUILDER

    public static class PersonBuilder {

        private String name;
        private String cpf;
        private LocalDate birthDate;

        public PersonBuilder personName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder personCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public PersonBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
