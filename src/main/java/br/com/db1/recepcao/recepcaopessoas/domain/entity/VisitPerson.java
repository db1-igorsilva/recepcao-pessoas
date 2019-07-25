package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "visit_person")
public class VisitPerson {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "person", nullable = false)
    private String person;

    @ManyToOne
    @JoinColumn(name = "id_visit", referencedColumnName = "id")
    private Visit visit;

    protected VisitPerson() { }

    public VisitPerson(Visit visit, String person) {
        this.person = person;
        this.visit = visit;
    }

    // GETTERS AND SETTERS

    public UUID getId() {
        return id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

}
