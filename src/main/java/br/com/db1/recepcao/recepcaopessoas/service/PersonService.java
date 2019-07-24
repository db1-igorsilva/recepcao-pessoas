package br.com.db1.recepcao.recepcaopessoas.service;

import br.com.db1.recepcao.recepcaopessoas.domain.dto.PersonDTO;
import br.com.db1.recepcao.recepcaopessoas.domain.entity.Person;
import br.com.db1.recepcao.recepcaopessoas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonDTO save(PersonDTO dto) {
        Person guest = new Person.PersonBuilder()
                .personName(dto.getName())
                .personCpf(dto.getCpf())
                .build();
        return personToDto(personRepository.save(guest));
    }

    // READ

    public List<PersonDTO> getAll() {
        List<Person> persons = personRepository.findAll();
        List<PersonDTO> allPersonsInDto = persons.stream()
                .map(person -> personToDto(person))
                .collect(Collectors.toList());
        return allPersonsInDto;
    }

    // UPDATE

    // DELETE

    public void delete(UUID id) {
        Person personToDelete = personRepository.getOne(id);
        personRepository.delete(personToDelete);
    }

    // METHODS

    private PersonDTO personToDto(Person person) {
        return new PersonDTO(person.getId(), person.getName(),
                person.getCpf());
    }

}
