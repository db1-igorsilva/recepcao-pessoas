package br.com.db1.recepcao.recepcaopessoas.resource;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.VisitDTO;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.Guest;
import br.com.db1.recepcao.recepcaopessoas.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/visit")
public class VisitResource {

    @Autowired
    private VisitService visitService;

    @GetMapping(value = "/getByDate/{date}")
    public List<VisitDTO> getByDate(@RequestParam("date") LocalDate date) {
        return visitService.getByDate(date);
    }

    @GetMapping(value = "/getByGuest/{guest}")
    public List<VisitDTO> getByGuest(@RequestParam("guest") UUID id) {
        return visitService.getByGuest(id);
    }

}
