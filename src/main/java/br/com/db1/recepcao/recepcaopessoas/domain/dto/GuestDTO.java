package br.com.db1.recepcao.recepcaopessoas.domain.dto;

import br.com.db1.recepcao.recepcaopessoas.domain.entity.RelationshipType;

import java.io.Serializable;
import java.util.UUID;

public class GuestDTO implements Serializable {

    public static final long serialVersionUID = 23L;

    private UUID id;
    private String name;
    private RelationshipType relationshipType;

}
