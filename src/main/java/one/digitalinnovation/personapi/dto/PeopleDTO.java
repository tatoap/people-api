package one.digitalinnovation.personapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO {

    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 100)
    private String lastName;

    @NotBlank
    private String cpf;

    @Valid
    private List<PhoneDTO> phones;

    @NotNull
    private LocalDate birthDate;

    @Valid
    @NotNull
    private AddressDTO address;
}
