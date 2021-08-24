package one.digitalinnovation.personapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotBlank
    @Size(min = 2, max = 100)
    private String address1;

    @Size(min = 2, max = 100)
    private String address2;

    @NotBlank
    @Size(min = 2, max = 10)
    private String number;

    @NotBlank
    @Size(min = 2, max = 50)
    private String district;

    @NotBlank
    @Size(min = 9, max = 10)
    private String zipCode;

    @NotNull
    private CityDTO city;

}
