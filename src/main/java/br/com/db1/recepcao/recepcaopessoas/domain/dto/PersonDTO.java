package br.com.db1.recepcao.recepcaopessoas.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class PersonDTO implements Serializable {

    public static final long serialVersionUID = 23L;

    private UUID id;
    private String name;
    private String cpf;
    private LocalDate birthDate;

    // CONSTRUCTOR

    private PersonDTO(UUID id, String name,
                      String cpf, LocalDate birthDate) {
        setId(id);
        setName(name);
        setCpf(cpf);
        setBirthDate(birthDate);
    }

    // EQUALS AND HASH

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO)) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return getId().equals(personDTO.getId()) &&
                getName().equals(personDTO.getName()) &&
                getCpf().equals(personDTO.getCpf()) &&
                getBirthDate().equals(personDTO.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCpf());
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
