package br.com.db1.recepcao.recepcaopessoas.resource;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.GuestDTO;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.RelationshipType;
import br.com.db1.recepcao.recepcaopessoas.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/guest")
public class GuestResource {

    @Autowired
    private GuestService guestService;

    @PostMapping
    public GuestDTO post(@RequestBody GuestDTO body) {
        return guestService.save(body);
    }

    @GetMapping(value = "/getByName/{name}")
    public GuestDTO getByName(@PathVariable("name") String name) {
        return guestService.getByName(name);
    }

    @GetMapping(value = "/getByRelationshipType/{relationshipType}")
    public List<GuestDTO> getByRelationshipType(@PathVariable("relationshipType") RelationshipType relationshipType) {
        return guestService.getByRelationshipType(relationshipType);
    }

}
