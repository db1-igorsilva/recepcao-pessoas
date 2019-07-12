package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "visit_guest")
public class VisitGuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToMany(name = "person", nullable = false)
    private List<Person> person;

    @ManyToOne
    @JoinColumn(name = "id_visit", nullable = false, referencedColumnName = "id")
    private Visit visit;

    public VisitGuest(Guest guest, Visit visit) {
        this.guest = guest;
        this.visit = visit;
    }

}
