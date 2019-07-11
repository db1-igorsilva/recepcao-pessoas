package br.com.db1.recepcao.recepcaopessoas.repository;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.VisitDTO;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface VisitRepository extends JpaRepository<Visit, UUID> {

    VisitDTO findByDate(LocalDate date);
    VisitDTO findByGuest(Guest guest);

}
