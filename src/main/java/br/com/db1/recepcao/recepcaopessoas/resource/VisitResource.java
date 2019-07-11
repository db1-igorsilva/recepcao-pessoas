package br.com.db1.recepcao.recepcaopessoas.resource;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.VisitDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/visit")
public class VisitResource {

    @GetMapping(value = "/getByDate/{date}")
    public List<VisitDTO> getByDate(@RequestParam("date") LocalDate date) {
//        
    }

}
