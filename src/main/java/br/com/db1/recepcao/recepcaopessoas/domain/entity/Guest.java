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

    // BUILDER

    public static class GuestBuilder {

        private String name;
        private RelationshipType relationshipType;

        public GuestBuilder guestName(String name) {
            this.name = name;
            return this;
        }

        public GuestBuilder relatedBy(RelationshipType relationshipType) {
            this.relationshipType = relationshipType;
            return this;
        }

        public Guest build() {
            return new Guest(this);
        }

    }

    // CONSTRUCTOR

    protected Guest() {}

    private Guest(GuestBuilder builder) {
        name = builder.name;
        relationshipType = builder.relationshipType;
    }

    // METHODS

    // GETTERS

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }
    
}
