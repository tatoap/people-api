package one.digitalinnovation.personapi.dto;

import lombok.Getter;
import lombok.Setter;
import one.digitalinnovation.personapi.entity.Address;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PeopleDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String cpf;

    private List<PhoneDTO> phones;

    private LocalDate birthDate;

    private AddressDTO address;
}
