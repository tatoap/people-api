package one.digitalinnovation.personapi.dto.input;

import lombok.Getter;
import lombok.Setter;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PhoneInput {

    @NotNull
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotBlank
    private String number;

    private PeopleInput peopleInput;

}
