package one.digitalinnovation.personapi.assembler;

import one.digitalinnovation.personapi.dto.PeopleDTO;
import one.digitalinnovation.personapi.entity.People;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PeopleModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PeopleDTO toModel(People people) {
        return modelMapper.map(people, PeopleDTO.class);
    }

    public List<PeopleDTO> toCollectionModel(List<People> peoples) {
        return peoples.stream()
                .map(people -> toModel(people))
                .collect(Collectors.toList());
    }

}
