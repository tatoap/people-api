package one.digitalinnovation.personapi.dto.input;

import lombok.Getter;
import lombok.Setter;
import one.digitalinnovation.personapi.dto.AddressDTO;
import one.digitalinnovation.personapi.dto.PhoneDTO;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PeopleInput {

    @NotBlank
    private String firstName;

    private String lastName;

    @NotBlank
    private String cpf;

    private List<PhoneInput> phones;

    @NotNull
    private LocalDate birthDate;

    @Valid
    @NotNull
    private AddressInput address;

}
