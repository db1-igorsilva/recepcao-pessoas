package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "relationship_type", nullable = false)
    private RelationshipType relationshipType;

    // CONSTRUCTOR

    protected Guest() {}

    private Guest(GuestBuilder builder) {
        name = builder.name;
        relationshipType = builder.relationshipType;
    }

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

    // METHODS

    // GETTERS AND SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setRelationshipType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

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
