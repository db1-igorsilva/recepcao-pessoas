//package br.com.db1.recepcao.recepcaopessoas.domain.dto;
//
//import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;
//import br.com.db1.recepcao.recepcaopessoas.domain.entity.RelationshipType;
//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.List;
//import java.util.UUID;
//
//import static java.util.Arrays.asList;
//import static org.junit.Assert.*;
//
//public class VisitDTOTest {
//
//    private Guest guest = new Guest.GuestBuilder()
//            .guestName("Guest Name")
//            .relatedBy(RelationshipType.OTHER)
//            .build();
//    private List<String> persons = asList("First Person", "Second Person", "Third Person");
//    private String welcomeText = "W3lcome, mate!";
//
//    @Test
//    public void mustCreateOneVisitDTO() {
//        VisitDTO visitDTO = new VisitDTO(UUID.randomUUID(),
//                LocalDate.parse("3000-12-31"), LocalTime.parse("12:00:00"),
//                LocalTime.parse("14:30:00"), guest, persons, welcomeText);
//        assertNotNull(visitDTO);
//        assertEquals(persons, visitDTO.getVisitPerson());
//    }
//
//}
