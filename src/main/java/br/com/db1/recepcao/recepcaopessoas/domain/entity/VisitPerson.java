package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "visit_guest")
public class VisitPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "uuid")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_visit", referencedColumnName = "uuid")
    private Visit visit;

    protected VisitPerson() { }

    public VisitPerson(Person person, Visit visit) {
        this.person = person;
        this.visit = visit;
    }

    // GETTERS AND SETTERS

    public UUID getUuid() {
        return uuid;
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
