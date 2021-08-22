package one.digitalinnovation.personapi.assembler;

import one.digitalinnovation.personapi.dto.input.PeopleInput;
import one.digitalinnovation.personapi.entity.City;
import one.digitalinnovation.personapi.entity.People;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeopleInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public People toDomainObject(PeopleInput peopleInput) {
        return modelMapper.map(peopleInput, People.class);
    }

    public void copyToDomainObject(PeopleInput peopleInput, People people) {
        if (people.getAddress() != null) {
            people.getAddress().setCity(new City());
        }

        modelMapper.map(peopleInput, people);
    }
}
