package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "relationship_type", nullable = false)
    private RelationshipType relationshipType;

    protected Guest() {}

}
