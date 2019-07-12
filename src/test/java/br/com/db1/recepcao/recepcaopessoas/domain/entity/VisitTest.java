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
    private Person firstPerson = new Person.PersonBuilder()
                                            .personName("First Guest")
                                            .personCpf("107.463.599-00")
                                            .birthDate(LocalDate.parse("2000-11-16"))
                                            .build();
    private Person secondPerson = new Person.PersonBuilder()
                                            .personName("Second Guest")
                                            .personCpf("107.465.599-00")
                                            .birthDate(LocalDate.parse("2000-11-16"))
                                            .build();
    private String welcomeText = "W3lcome, Company guests";
    private Visit visit;

    @Before
    public void before() {
        List<VisitPerson> visitPeople = asList(new VisitPerson(firstPerson, visit), new VisitPerson(secondPerson, visit));
        visit = new Visit.VisitBuilder()
                .onDate(date)
                .startingAt(presentationStartTime)
                .endingAt(presentationEndTime)
                .byGuest(guest)
                .byVisitPerson(visitPeople)
                .withWelcomeText(welcomeText)
                .build();
    }

    @Test
    public void visitCreatedOnBeforeMusntBeNull() {
        assertNotNull(visit);
    }

    @Test
    public void mustReturnAllPersonsOnVisit() {
        List<VisitPerson> visitPeople = visit.getVisitPerson();
        assertThat(visitPeople, not(empty()));
        assertEquals(2, visitPeople.size());
    }

}
