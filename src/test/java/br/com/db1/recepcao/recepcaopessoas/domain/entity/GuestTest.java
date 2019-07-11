package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GuestTest {

    private final static String name = "Guest Name";
    private final static RelationshipType relationship = RelationshipType.CLIENT;

    @Test
    public void mustCreateOneGuest() {
        Guest guest = new Guest.GuestBuilder()
                .guestName(name)
                .relatedBy(relationship)
                .build();
        assertNotNull(guest);
    }

}
