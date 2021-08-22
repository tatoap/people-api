package one.digitalinnovation.personapi.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressInput {

    @NotBlank
    private String address1;

    private String address2;

    @NotBlank
    private String number;

    @NotBlank
    private String district;

    @NotBlank
    private String zipCode;

    @Valid
    @NotNull
    private CityIdInput city;
}
