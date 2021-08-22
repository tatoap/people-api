package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.entity.City;
import one.digitalinnovation.personapi.exception.CityNotFoundException;
import one.digitalinnovation.personapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City seekOrFail(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new CityNotFoundException(cityId));
    }
}
