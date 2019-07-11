package br.com.db1.recepcao.recepcaopessoas.service;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.GuestDTO;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;
import br.com.db1.recepcao.recepcaopessoas.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // METHODS

    private GuestDTO guestToDto(Guest guest) {
        return new GuestDTO(guest.getId(), guest.getName(),
                guest.getRelationshipType());
    }

}
