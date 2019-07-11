package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GuestTest {

    private String name = "Guest Name";
    private RelationshipType relationship = RelationshipType.CLIENT;

    @Test
    public void mustCreateOneGuest() {
        Guest guest = new Guest.GuestBuilder()
                .guestName(name)
                .relatedBy(relationship)
                .build();
        assertNotNull(guest);
    }

}
