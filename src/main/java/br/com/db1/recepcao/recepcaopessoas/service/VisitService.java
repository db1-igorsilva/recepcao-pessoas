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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VisitService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private VisitRepository visitRepository;

    // CREATE

    public VisitDTO save(VisitDTO dto) {
        Visit visit = new Visit.VisitBuilder()
                .onDate(dto.getDate())
                .startingAt(dto.getPresentationStartTime())
                .endingAt(dto.getPresentationEndTime())
                .byGuest(guestRepository.findByName(dto.getGuest()))
                .withWelcomeText(dto.getWelcomeText())
                .build();
        return visitToDto(visitRepository.save(visit));
    }

    // READ

    public List<VisitDTO> getAll() {
        List<Visit> visits = visitRepository.findAll();
        List<VisitDTO> allVisitsInDto = visits.stream()
                .map(visit -> visitToDto(visit))
                .collect(Collectors.toList());
        return allVisitsInDto;
    }

    public VisitDTO getOne(UUID id) {
        Visit visit = visitRepository.getOne(id);
        return visitToDto(visit);
    }

    public List<VisitDTO> getByDate(LocalDate date) {
        List<Visit> visitsOnThatDate = visitRepository.findByDate(date);
        List<VisitDTO> visitsDtos = visitsOnThatDate.stream()
                .map(visit -> visitToDto(visit))
                .collect(Collectors.toList());
        return visitsDtos;
    }

    public List<VisitDTO> getByGuest(UUID id) {
        Guest guest = guestRepository.getOne(id);
        List<Visit> visitsFromTheGuest = visitRepository.findByGuest(guest);
        List<VisitDTO> visitsDtos = visitsFromTheGuest.stream()
                .map(visit -> visitToDto(visit))
                .collect(Collectors.toList());
        return visitsDtos;
    }

    // UPDATE

    public VisitDTO put(UUID id, VisitDTO dto) {
        Visit visitToUpdate = visitRepository.getOne(id);
        visitToUpdate.setDate(dto.getDate());
        visitToUpdate.setPresentationStartTime(dto.getPresentationStartTime());
        visitToUpdate.setPresentationEndTime(dto.getPresentationEndTime());
        visitToUpdate.setGuest(guestRepository.findByName(dto.getGuest()));
        visitToUpdate.setWelcomeText(dto.getWelcomeText());
        return visitToDto(visitRepository.save(visitToUpdate));
    }

    // DELETE

    public void delete(UUID id) {
        Visit visitToDelete = visitRepository.getOne(id);
        visitRepository.delete(visitToDelete);
    }

    // METHODS

    private VisitDTO visitToDto(Visit visit) {
        System.out.println(visit);
        System.out.println(visit.getId());
        System.out.println(visit.getDate());
        System.out.println(visit.getPresentationStartTime());
        System.out.println(visit.getPresentationEndTime());
        System.out.println(visit.getGuest().getName());
        System.out.println(visit.getWelcomeText());
        return new VisitDTO(visit.getId(), visit.getDate(),
                visit.getPresentationStartTime(), visit.getPresentationEndTime(),
                visit.getGuest().getName(), visit.getWelcomeText());
    }

}
