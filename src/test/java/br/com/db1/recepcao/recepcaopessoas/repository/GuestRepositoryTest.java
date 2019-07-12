package br.com.db1.recepcao.recepcaopessoas.repository;

import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.RelationshipType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GuestRepositoryTest {

    private String clientGuestName = "Client";
    private String otherGuestName = "Other";
    private String supplierWhoIsActuallyAClientName = "Supplier";
    private String universityGuestName = "University";

    private Guest clientGuest = new Guest.GuestBuilder()
            .guestName(clientGuestName)
            .relatedBy(RelationshipType.CLIENT)
            .build();
    private Guest otherGuest = new Guest.GuestBuilder()
            .guestName(otherGuestName)
            .relatedBy(RelationshipType.OTHER)
            .build();
    private Guest supplierWhoIsActuallyAClientGuest = new Guest.GuestBuilder()
            .guestName(supplierWhoIsActuallyAClientName)
            .relatedBy(RelationshipType.CLIENT)
            .build();
    private Guest universityGuest = new Guest.GuestBuilder()
            .guestName(universityGuestName)
            .relatedBy(RelationshipType.UNIVERSITY)
            .build();
    private List<Guest> guests = asList(clientGuest, otherGuest, supplierWhoIsActuallyAClientGuest, universityGuest);

    private GuestRepository fakeGuestRepository = mock(GuestRepository.class);

    @Before
    public void before() {
        when(fakeGuestRepository.saveAll(guests)).thenReturn(guests);
        whenReturnByName(clientGuestName, clientGuest);
    }

    @Test
    public void mustReturnAllSavedGuests() {
        List<Guest> savedGuests = fakeGuestRepository.saveAll(guests);
        assertFalse(savedGuests.isEmpty());
        assertEquals(guests.size(), savedGuests.size());
    }

    @Test
    public void mustReturnClientGuestWhenClientGuestNameIsPassed() {
        Guest guest = fakeGuestRepository.findByName(clientGuestName);
        assertEquals(clientGuest, guest);
    }

    @Test
    public void mustReturnNullWhenInexistentNameIsPassed() {
        Guest guest = fakeGuestRepository.findByName("Random Name");
        assertNull(guest);
    }

    @Test
    public void mustReturnAllClientsWhenClientRelationshipIsPassed() {
        RelationshipType relationship = RelationshipType.CLIENT;
        whenReturnByRelationship(relationship);
        List<Guest> clients = fakeGuestRepository.findByRelationshipType(relationship);
        assertEquals(2, clients.size());
        assertTrue(clients.stream()
                .allMatch(client -> client.getRelationshipType()
                        .equals(relationship)));
    }

    @Test
    public void mustReturnNoneGuestWhenSupplierRelationshipIsPassed() {
        RelationshipType relationship = RelationshipType.SUPPLIER;
        whenReturnByRelationship(relationship);
        List<Guest> suppliers = fakeGuestRepository.findByRelationshipType(relationship);
        assertTrue(suppliers.isEmpty());
    }

    private void whenReturnByRelationship(RelationshipType relationship) {
        when(fakeGuestRepository.findByRelationshipType(relationship))
                .thenReturn(guests.stream()
                        .filter(guest -> guest.getRelationshipType()
                                .equals(relationship))
                        .collect(Collectors.toList()));
    }

    private void whenReturnByName(String name, Guest guest) {
        when(fakeGuestRepository.findByName(name))
                .thenReturn(guest);
    }

}
