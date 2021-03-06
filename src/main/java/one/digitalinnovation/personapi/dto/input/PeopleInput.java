package one.digitalinnovation.personapi.dto.input;

import lombok.Getter;
import lombok.Setter;

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

    @NotBlank
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
