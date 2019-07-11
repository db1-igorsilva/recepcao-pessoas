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

}
