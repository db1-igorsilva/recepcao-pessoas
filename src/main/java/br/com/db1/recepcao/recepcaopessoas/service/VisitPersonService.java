package br.com.db1.recepcao.recepcaopessoas.service;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.VisitPersonDTO;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.VisitPerson;
import br.com.db1.recepcao.recepcaopessoas.repository.VisitPersonRepository;
import br.com.db1.recepcao.recepcaopessoas.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VisitPersonService {

    @Autowired
    private VisitPersonRepository visitPersonRepository;

    @Autowired
    private VisitRepository visitRepository;

    // CREATE

    public VisitPersonDTO save(VisitPersonDTO dto) {
        VisitPerson visitPerson = new VisitPerson(visitRepository.getOne(dto.getVisit()), dto.getPerson());
        return visitPersonToDto(visitPersonRepository.save(visitPerson));
    }

    // READ

    public List<VisitPersonDTO> getAll() {
        List<VisitPerson> visitPersons = visitPersonRepository.findAll();
        List<VisitPersonDTO> allVisitPersonDtos = visitPersons.stream()
                .map(visitPerson -> visitPersonToDto(visitPerson))
                .collect(Collectors.toList());
        return allVisitPersonDtos;
    }

    // UPDATE

    // DELETE

    public void delete(UUID id) {
        VisitPerson visitPersonToDelete = visitPersonRepository.getOne(id);
        visitPersonRepository.delete(visitPersonToDelete);
    }

    // METHODS

    private VisitPersonDTO visitPersonToDto(VisitPerson visitPerson) {
        return new VisitPersonDTO(visitPerson.getId(),
                    visitPerson.getVisit().getId(),
                    visitPerson.getPerson());
    }

}
