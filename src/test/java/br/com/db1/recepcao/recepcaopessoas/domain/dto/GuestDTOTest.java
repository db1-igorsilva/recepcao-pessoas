package br.com.db1.recepcao.recepcaopessoas.domain.dto;

import br.com.db1.recepcao.recepcaopessoas.domain.entity.RelationshipType;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GuestDTOTest {

    private String name = "Guest Name";
    private RelationshipType relationship = RelationshipType.OTHER;

    @Test
    public void mustCreateOneGuestDTO() {
        GuestDTO guestDTO = new GuestDTO(UUID.randomUUID(),
                name, relationship);
        assertNotNull(guestDTO);
        assertEquals(name, guestDTO.getName());
    }

}
