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

    @Column(name = "names", nullable = false)
    private List<String> names;

    @Column(name = "welcome_text", nullable = false)
    private String welcomeText;

}
