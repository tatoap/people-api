package one.digitalinnovation.personapi.dto.input;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import one.digitalinnovation.personapi.entity.People;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;
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

}
