package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

    @ManyToOne
    @JoinColumn(name = "id_guest", referencedColumnName = "id")
    private Guest guest;

    @OneToMany(mappedBy = "visit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<VisitPerson> visitPerson = new ArrayList<>();

    @Column(name = "welcome_text", nullable = false)
    private String welcomeText;

    // CONSTRUCTOR

    protected Visit() {}

    private Visit(VisitBuilder builder) {
        date = builder.date;
        presentationStartTime = builder.presentationStartTime;
        presentationEndTime = builder.presentationEndTime;
        guest = builder.guest;
        visitPerson = builder.persons;
        welcomeText = builder.welcomeText;
    }

    // BUILDER

    public static class VisitBuilder {

        private LocalDate date;
        private LocalTime presentationStartTime;
        private LocalTime presentationEndTime;
        private Guest guest;
        private List<VisitPerson> persons;
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

        public VisitBuilder byVisitPerson(List<VisitPerson> persons) {
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

    // METHODS

    public void addPerson(Person person) {
        this.visitPerson.add(new VisitPerson(person, this));
    }

    // GETTERS AND SETTERS

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPresentationStartTime(LocalTime presentationStartTime) {
        this.presentationStartTime = presentationStartTime;
    }

    public void setPresentationEndTime(LocalTime presentationEndTime) {
        this.presentationEndTime = presentationEndTime;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setVisitPerson(List<VisitPerson> visitPerson) {
        this.visitPerson = visitPerson;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getPresentationStartTime() {
        return presentationStartTime;
    }

    public LocalTime getPresentationEndTime() {
        return presentationEndTime;
    }

    public Guest getGuest() {
        return guest;
    }

    public List<VisitPerson> getVisitPerson() {
        return visitPerson;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

}
