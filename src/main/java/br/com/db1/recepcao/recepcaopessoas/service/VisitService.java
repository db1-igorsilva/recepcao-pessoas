package br.com.db1.recepcao.recepcaopessoas.service;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.VisitDTO;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.Visit;
import br.com.db1.recepcao.recepcaopessoas.repository.GuestRepository;
import br.com.db1.recepcao.recepcaopessoas.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private GuestRepository guestRepository;

    public List<VisitDTO> getByDate(LocalDate date) {
        List<Visit> visitsOnThatDate = visitRepository.findByDate(date);
        List<VisitDTO> visitsDtos = visitsOnThatDate.stream()
                .map(visit -> visitToDto(visit))
                .collect(Collectors.toList());
        return visitsDtos;
    }

    public List<VisitDTO> getByGuest(Guest guest) {
        List<Visit> visitsFromTheGuest = visitRepository.findByGuest(guest);
        List<VisitDTO> visitsDto = visitsFromTheGuest.stream()
                .map(visit -> visitToDto(visit))
                .collect(Collectors.toList());
        return visitsDto;
    }

    private VisitDTO visitToDto(Visit visit) {
        return new VisitDTO(visit.getId(), visit.getDate(),
                visit.getPresentationStartTime(), visit.getPresentationEndTime(),
                visit.getGuest(), visit.getPersons(), visit.getWelcomeText());
    }

}
