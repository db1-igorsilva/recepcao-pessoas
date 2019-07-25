package br.com.db1.recepcao.recepcaopessoas.domain.dto;

import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.VisitPerson;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class VisitDTO implements Serializable {

    public static final long serialVersionUID = 23L;

    private UUID id;
    private LocalDate date;
    private LocalTime presentationStartTime;
    private LocalTime presentationEndTime;
    private String guest;
    private String welcomeText;

    // CONSTRUCTOR

    public VisitDTO(UUID id, LocalDate date,
                    LocalTime presentationStartTime,
                    LocalTime presentationEndTime,
                    String guest,
                    String welcomeText) {
        setId(id);
        setDate(date);
        setPresentationStartTime(presentationStartTime);
        setPresentationEndTime(presentationEndTime);
        setGuest(guest);
        setWelcomeText(welcomeText);
    }

    // EQUALS AND HASH

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitDTO)) return false;
        VisitDTO visitDTO = (VisitDTO) o;
        return id.equals(visitDTO.id) &&
                date.equals(visitDTO.date) &&
                presentationStartTime.equals(visitDTO.presentationStartTime) &&
                presentationEndTime.equals(visitDTO.presentationEndTime) &&
                guest.equals(visitDTO.guest) &&
                welcomeText.equals(visitDTO.welcomeText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }

}
