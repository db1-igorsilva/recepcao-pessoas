package br.com.db1.recepcao.recepcaopessoas.domain.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(GenerationType.IDENTITY)
    private UUID id;

}
