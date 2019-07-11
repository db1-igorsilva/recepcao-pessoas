package br.com.db1.recepcao.recepcaopessoas.repository;

import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.RelationshipType;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestRepositoryTest {

    private final static String guestName = "University";
    private GuestRepository fakeGuestRepository = mock(GuestRepository.class);
    private Guest universityGuest = new Guest.GuestBuilder()
            .guestName(guestName)
            .relatedBy(RelationshipType.UNIVERSITY)
            .build();

}
