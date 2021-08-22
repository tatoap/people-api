package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.assembler.PeopleInputDisassembler;
import one.digitalinnovation.personapi.assembler.PeopleModelAssembler;
import one.digitalinnovation.personapi.dto.PeopleDTO;
import one.digitalinnovation.personapi.dto.input.PeopleInput;
import one.digitalinnovation.personapi.entity.People;
import one.digitalinnovation.personapi.repository.PeopleRepository;
import one.digitalinnovation.personapi.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private PeopleModelAssembler peopleModelAssembler;

    @Autowired
    private PeopleInputDisassembler peopleInputDisassembler;

    @GetMapping
    public List<PeopleDTO> findAll() {
        return peopleModelAssembler.toCollectionModel(peopleRepository.findAll());
    }

    @GetMapping("/{peopleId}")
    public People findPeople(@PathVariable Long peopleId) {
        return peopleService.seekOrFail(peopleId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeopleDTO save(@Valid @RequestBody PeopleInput peopleInput) {

        People people = peopleInputDisassembler.toDomainObject(peopleInput);

        return peopleModelAssembler.toModel(peopleService.save(people));
    }

    @DeleteMapping("/{peopleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long peopleId) {
        peopleService.delete(peopleId);
    }
}
