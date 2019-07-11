package br.com.db1.recepcao.recepcaopessoas.domain.dto;

import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class VisitDTO implements Serializable {

    public static final long serialVersionUID = 23L;

    private UUID id;
    private LocalDate date;
    private LocalTime presentationStartTime;
    private LocalTime presentationEndTime;
    private Guest guest;
    private List<String> persons;
    private String welcomeText;

    // CONSTRUCTOR

    public VisitDTO(UUID id, LocalDate date,
                    LocalTime presentationStartTime,
                    LocalTime presentationEndTime,
                    Guest guest,
                    List<String> persons,
                    String welcomeText) {
        setId(id);
        setDate(date);
        setPresentationStartTime(presentationStartTime);
        setPresentationEndTime(presentationEndTime);
        setGuest(guest);
        setPersons(persons);
        setWelcomeText(welcomeText);
    }

    // GETTERS AND SETTERS

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getPresentationStartTime() {
        return presentationStartTime;
    }

    public void setPresentationStartTime(LocalTime presentationStartTime) {
        this.presentationStartTime = presentationStartTime;
    }

    public LocalTime getPresentationEndTime() {
        return presentationEndTime;
    }

    public void setPresentationEndTime(LocalTime presentationEndTime) {
        this.presentationEndTime = presentationEndTime;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public List<String> getPersons() {
        return persons;
    }

    public void setPersons(List<String> persons) {
        this.persons = persons;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }

}
