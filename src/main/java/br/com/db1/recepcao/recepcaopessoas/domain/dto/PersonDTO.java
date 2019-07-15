package br.com.db1.recepcao.recepcaopessoas.domain.dto;

import java.time.LocalDate;
import java.util.UUID;

public class PersonDTO {

    private UUID id;
    private String name;
    private String cpf;
    private LocalDate birthDate;

    private PersonDTO(UUID id, String name, String cpf, LocalDate birthDate) {
        setId(id);
        setName(name);
        setCpf(cpf);
        setBirthDate(birthDate);
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
