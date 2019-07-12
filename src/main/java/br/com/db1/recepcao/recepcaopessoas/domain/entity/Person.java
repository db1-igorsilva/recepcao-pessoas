package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    private UUID uuid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    protected Person() { }

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.cpf = builder.cpf;
        this.birthDate = builder.birthDate;
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

}
