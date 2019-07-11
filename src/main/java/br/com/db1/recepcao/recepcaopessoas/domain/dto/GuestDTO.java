package br.com.db1.recepcao.recepcaopessoas.domain.dto;

import br.com.db1.recepcao.recepcaopessoas.domain.entity.RelationshipType;

import java.io.Serializable;
import java.util.UUID;

public class GuestDTO implements Serializable {

    public static final long serialVersionUID = 23L;

    private UUID id;
    private String name;
    private RelationshipType relationshipType;

    // CONSTRUCTOR

    public GuestDTO(UUID id, String name,
                    RelationshipType relationshipType) {
        this.id = id;
        this.name = name;
        this.relationshipType = relationshipType;
    }

    // GETTERS AND SETTERS

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

}
