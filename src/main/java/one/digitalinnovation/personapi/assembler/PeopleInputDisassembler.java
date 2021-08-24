package one.digitalinnovation.personapi.assembler;

import one.digitalinnovation.personapi.dto.input.PeopleInput;
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

}
