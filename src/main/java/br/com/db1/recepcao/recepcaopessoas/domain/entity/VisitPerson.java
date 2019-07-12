package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "visit_guest")
public class VisitPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToMany(mappedBy = "visit_person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Person> persons;

    @ManyToOne
    @JoinColumn(name = "id_visit", nullable = false, referencedColumnName = "id")
    private Visit visit;

    public VisitPerson(List<Person> persons, Visit visit) {
        this.persons = persons;
        this.visit = visit;
    }

}
