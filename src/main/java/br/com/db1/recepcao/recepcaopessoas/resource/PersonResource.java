package br.com.db1.recepcao.recepcaopessoas.resource;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.PersonDTO;
import br.com.db1.recepcao.recepcaopessoas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/post")
    public PersonDTO post(@RequestBody PersonDTO body) {
        return personService.save(body);
    }

    @GetMapping(value = "/getAll")
    public List<PersonDTO> getAll() {
        return personService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") UUID id) {
        personService.delete(id);
    }

}
