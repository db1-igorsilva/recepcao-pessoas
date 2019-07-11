package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "presentation_start_time", nullable = false)
    private LocalTime presentationStartTime;

    @Column(name = "presentation_end_time", nullable = false)
    private LocalTime presentationEndTime;

    @Column(name = "guest", nullable = false)
    private Guest guest;

    @Column(name = "persons", nullable = false)
    private List<String> persons;

    @Column(name = "welcome_text", nullable = false)
    private String welcomeText;

    // BUILDER

    public static class VisitBuilder {

        private LocalDate date;
        private LocalTime presentationStartTime;
        private LocalTime presentationEndTime;
        private Guest guest;
        private List<String> persons;
        private String welcomeText;

        public VisitBuilder onDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public VisitBuilder startingAt(LocalTime presentationStartTime) {
            this.presentationStartTime = presentationStartTime;
            return this;
        }

        public VisitBuilder endingAt(LocalTime presentationEndTime) {
            this.presentationEndTime = presentationEndTime;
            return this;
        }

        public VisitBuilder byGuest(Guest guest) {
            this.guest = guest;
            return this;
        }

        public VisitBuilder byPersons(List<String> persons) {
            this.persons = persons;
            return this;
        }

        public VisitBuilder withWelcomeText(String welcomeText) {
            this.welcomeText = welcomeText;
            return this;
        }

        public Visit build() {
            return new Visit(this);
        }

    }

    // CONSTRUCTOR

    protected Visit() {}

    private Visit(VisitBuilder builder) {
        date = builder.date;
        presentationStartTime = builder.presentationStartTime;
        presentationEndTime = builder.presentationEndTime;
        guest = builder.guest;
        persons = builder.persons;
        welcomeText = builder.welcomeText;
    }

    // METHODS

}
