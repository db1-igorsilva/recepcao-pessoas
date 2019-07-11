package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class VisitTest {

    private final static LocalDate date = LocalDate.parse("3000-12-31");
    private final static LocalTime presentationStartTime = LocalTime.parse("12");
    private final static LocalTime presentationEndTime = LocalTime.parse("14:30");
    private final static Guest guest = new Guest.GuestBuilder()
            .guestName("Company")
            .relatedBy(RelationshipType.OTHER)
            .build();
    private final static List<String> persons = asList("First Guest", "Second Guest", "Third Guest", "Last Guest");
    private final static String welcomeText = "Bem-Vindos, convidados da Company";
    private Visit visit;

    @Before
    public void before() {
        visit = new Visit.VisitBuilder()
                .onDate(date)
                .startingAt(presentationStartTime)
                .endingAt(presentationEndTime)
                .byGuest(guest)
                .byPersons(persons)
                .withWelcomeText(welcomeText)
                .build();
    }

    @Test
    public void visitCreatedOnBeforeMusntBeNull() {
        assertNotNull(visit);
    }

    @Test
    public void mustReturnAllPersonsOnVisit() {
        List<String> persons = visit.getPersons();
        assertEquals(4, persons.size());
        assertThat(persons, not(empty()));
    }

}
