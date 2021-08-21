package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.entity.People;
import one.digitalinnovation.personapi.exception.EntityNotFoundException;
import one.digitalinnovation.personapi.exception.PeopleNotFoundException;
import one.digitalinnovation.personapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Transactional
    public People save(People people) {
        people.getPhones().forEach(p -> p.setPeople(people));

        return peopleRepository.save(people);
    }

    @Transactional
    public void delete(Long peopleId) {
        try {
            peopleRepository.deleteById(peopleId);
            peopleRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new PeopleNotFoundException(peopleId);
        }
    }

    public People seekOrFail(Long peopleId) {
        return peopleRepository.findById(peopleId)
                .orElseThrow(() -> new PeopleNotFoundException(peopleId));
    }
}
