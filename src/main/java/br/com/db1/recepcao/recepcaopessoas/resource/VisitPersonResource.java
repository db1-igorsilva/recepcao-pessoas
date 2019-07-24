package br.com.db1.recepcao.recepcaopessoas.resource;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.VisitPersonDTO;
import br.com.db1.recepcao.recepcaopessoas.service.VisitPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/visitPerson")
public class VisitPersonResource {

    @Autowired
    private VisitPersonService visitPersonService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/post")
    public VisitPersonDTO post(@RequestBody VisitPersonDTO body) {
        return visitPersonService.save(body);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/getAll")
    public List<VisitPersonDTO> getAll() {
        return visitPersonService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") UUID id) {
        visitPersonService.delete(id);
    }

}
