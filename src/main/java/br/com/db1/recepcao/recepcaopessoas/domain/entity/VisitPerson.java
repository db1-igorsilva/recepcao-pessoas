package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "visit_guest")
public class VisitPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_person", nullable = false, referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_visit", nullable = false, referencedColumnName = "id")
    private Visit visit;

    protected VisitPerson() { }

    public VisitPerson(Person person, Visit visit) {
        this.person = person;
        this.visit = visit;
    }

    // GETTERS AND SETTERS

    public UUID getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

}
