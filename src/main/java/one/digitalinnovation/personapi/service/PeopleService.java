package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.entity.City;
import one.digitalinnovation.personapi.entity.People;
import one.digitalinnovation.personapi.exception.CPFAlreadyIncludeException;
import one.digitalinnovation.personapi.exception.PeopleNotFoundException;
import one.digitalinnovation.personapi.repository.PeopleRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private CityService cityService;

    @Transactional
    public People include(People people) {
        try {
            City city = cityService.seekOrFail(people.getAddress().getCity().getId());

            people.getPhones().forEach(p -> p.setPeople(people));

            people.getAddress().setCity(city);

            return peopleRepository.save(people);
        } catch (DataIntegrityViolationException e) {
            throw new CPFAlreadyIncludeException(people.getCpf());
        }

    }

    @Transactional
    public People update(Long peopleId, People people) {
        People peopleSave = seekOrFail(peopleId);

        peopleSave.getPhones().clear();
        peopleSave.getPhones().addAll(people.getPhones());
        //peopleSave.getPhones().forEach(p -> p.setPeople(peopleSave));

        BeanUtils.copyProperties(people, peopleSave, "id", "phones");

        //return peopleRepository.save(peopleSave);
        return include(peopleSave);
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
