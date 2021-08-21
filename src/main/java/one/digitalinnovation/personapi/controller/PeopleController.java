package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.entity.People;
import one.digitalinnovation.personapi.repository.PeopleRepository;
import one.digitalinnovation.personapi.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private PeopleService peopleService;

    @GetMapping
    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    @GetMapping("/{peopleId}")
    public People findPeople(@PathVariable Long peopleId) {
        return peopleService.seekOrFail(peopleId);
    }

    @PostMapping
    public People save(@RequestBody People people) {
        return peopleService.save(people);
    }
}
