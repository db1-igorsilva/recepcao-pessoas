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

    private LocalDate date = LocalDate.parse("3000-12-31");
    private LocalTime presentationStartTime = LocalTime.parse("12:00:00");
    private LocalTime presentationEndTime = LocalTime.parse("14:30:00");
    private Guest guest = new Guest.GuestBuilder()
            .guestName("Company")
            .relatedBy(RelationshipType.OTHER)
            .build();
    private List<String> persons = asList("First Guest", "Second Guest", "Third Guest", "Last Guest");
    private String welcomeText = "W3lcome, Company guests";
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
