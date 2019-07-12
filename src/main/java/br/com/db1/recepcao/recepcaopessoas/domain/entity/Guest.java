package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    private UUID uuid;

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

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }
    
}
