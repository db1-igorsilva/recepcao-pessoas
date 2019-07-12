package br.com.db1.recepcao.recepcaopessoas.repository;

import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.RelationshipType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestRepositoryTest {

    private String universityGuestName = "University";
    private String clientGuestName = "Client";
    private String supplierGuestName = "Supplier";
    private String otherGuestName = "Other";

    private Guest universityGuest = new Guest.GuestBuilder()
            .guestName(universityGuestName)
            .relatedBy(RelationshipType.UNIVERSITY)
            .build();
    private Guest clientGuest = new Guest.GuestBuilder()
            .guestName(clientGuestName)
            .relatedBy(RelationshipType.CLIENT)
            .build();
    private Guest supplierGuest = new Guest.GuestBuilder()
            .guestName(supplierGuestName)
            .relatedBy(RelationshipType.SUPPLER)
            .build();
    private Guest otherGuest = new Guest.GuestBuilder()
            .guestName(otherGuestName)
            .relatedBy(RelationshipType.OTHER)
            .build();
    private List<Guest> guests = asList(universityGuest, clientGuest, supplierGuest, otherGuest);

    private GuestRepository fakeGuestRepository = mock(GuestRepository.class);

    @Before
    public void before() {
        fakeGuestRepository.saveAll(guests);
//        when(fakeGuestRepository.findByName(universityGuestName)).thenReturn(universityGuest);
//        when(fakeGuestRepository.findByName(clientGuestName)).thenReturn(clientGuest);
//        when(fakeGuestRepository.findByName(supplierGuestName)).thenReturn(supplierGuest);
//        when(fakeGuestRepository.findByName(otherGuestName)).thenReturn(otherGuest);
    }

    @Test
    public void mustReturnUniversityGuestWhenUniversityGuestNameIsPassed() {
        Guest guest = fakeGuestRepository.findByName(universityGuestName);
        assertThat(guest, not(null));
        assertEquals(universityGuest, guest);
    }

    @Test
    public void mustReturnClientGuestWhenUniversityGuestNameIsPassed() {
        Guest guest = fakeGuestRepository.findByName(clientGuestName);
        assertThat(guest, not(null));
        assertEquals(clientGuestName, guest);
    }

    @Test
    public void mustReturnSupplierGuestWhenUniversityGuestNameIsPassed() {
        Guest guest = fakeGuestRepository.findByName(supplierGuestName);
        assertThat(guest, not(null));
        assertEquals(supplierGuestName, guest);
    }

    @Test
    public void mustReturnOtherGuestWhenUniversityGuestNameIsPassed() {
        Guest guest = fakeGuestRepository.findByName(otherGuestName);
        assertThat(guest, not(null));
        assertEquals(otherGuestName, guest);
    }

}
