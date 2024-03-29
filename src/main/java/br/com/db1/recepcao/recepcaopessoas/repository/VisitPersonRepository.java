package br.com.db1.recepcao.recepcaopessoas.repository;

import br.com.db1.recepcao.recepcaopessoas.domain.entity.Visit;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.VisitPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VisitPersonRepository extends JpaRepository<VisitPerson, UUID> {
    List<VisitPerson> getByVisit(Visit visit);
}
