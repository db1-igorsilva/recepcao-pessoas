package br.com.db1.recepcao.recepcaopessoas.service;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.GuestDTO;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.RelationshipType;
import br.com.db1.recepcao.recepcaopessoas.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    // CREATE

    public GuestDTO save(GuestDTO dto) {
        Guest guest = new Guest.GuestBuilder()
                .guestName(dto.getName())
                .relatedBy(dto.getRelationshipType())
                .build();
        return guestToDto(guestRepository.save(guest));
    }

    // READ

    public GuestDTO getByName(String name) {
        Guest guest = guestRepository.findByName(name);
        return guestToDto(guest);
    }

    public List<GuestDTO> getByRelationshipType(RelationshipType relationshipType) {
        List<Guest> guestsWithThatRelationshipType = guestRepository.findByRelationshipType(relationshipType);
        List<GuestDTO> guestsDtos = guestsWithThatRelationshipType.stream()
                .map(guest -> guestToDto(guest))
                .collect(Collectors.toList());
        return guestsDtos;
    }

    // UPDATE

    public GuestDTO put(UUID id, GuestDTO dto) {
        Guest guestToUpdate = guestRepository.getOne(id);
        guestToUpdate.setName(dto.getName());
        guestToUpdate.setRelationshipType(dto.getRelationshipType());
        return guestToDto(guestRepository.save(guestToUpdate));
    }

    // DELETE

    public void delete(UUID id) {
        Guest guestToDelete = guestRepository.getOne(id);
        guestRepository.delete(guestToDelete);
    }

    // METHODS

    private GuestDTO guestToDto(Guest guest) {
        return new GuestDTO(guest.getId(), guest.getName(),
                            guest.getRelationshipType());
    }

}
