package br.com.db1.recepcao.recepcaopessoas.resource;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.VisitDTO;
import br.com.db1.recepcao.recepcaopessoas.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/visit")
public class VisitResource {

    @Autowired
    private VisitService visitService;

    @PostMapping(value = "/post")
    public VisitDTO post(@RequestBody VisitDTO body) {
        return visitService.save(body);
    }

    @GetMapping(value = "/getAll")
    public List<VisitDTO> getAll() {
        return visitService.getAll();
    }

    @GetMapping(value = "/getOne/{id}")
    public VisitDTO getOne(@PathVariable("id") UUID id) {
        return visitService.getOne(id);
    }

    @GetMapping(value = "/getByDate/{date}")
    public List<VisitDTO> getByDate(@PathVariable("date") LocalDate date) {
        return visitService.getByDate(date);
    }

    @GetMapping(value = "/getByGuest/{guest}")
    public List<VisitDTO> getByGuest(@PathVariable("guest") UUID id) {
        return visitService.getByGuest(id);
    }

    @PutMapping(value = "/{id}")
    public VisitDTO put(@PathVariable("id") UUID id, @RequestBody VisitDTO body) {
        return visitService.put(id, body);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") UUID id) {
        visitService.delete(id);
    }

}
