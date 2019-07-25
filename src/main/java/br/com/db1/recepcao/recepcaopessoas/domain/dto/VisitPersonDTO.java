package br.com.db1.recepcao.recepcaopessoas.domain.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class VisitPersonDTO implements Serializable {

    public static final long serialVersionUID = 23L;

    private UUID id;
    private UUID visit;
    private String person;

    // CONSTRUCTOR

    public VisitPersonDTO(UUID id, UUID visit, String person) {
        this.id = id;
        this.visit = visit;
        this.person = person;
    }

    // EQUALS AND HASH

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitPersonDTO)) return false;
        VisitPersonDTO that = (VisitPersonDTO) o;
        return getId().equals(that.getId()) &&
                getVisit().equals(that.getVisit()) &&
                getPerson().equals(that.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    // GETTERS AND SETTERS

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVisit() {
        return visit;
    }

    public void setVisit(UUID visit) {
        this.visit = visit;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

}