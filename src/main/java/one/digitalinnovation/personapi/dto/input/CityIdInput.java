package one.digitalinnovation.personapi.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CityIdInput {

    @NotNull
    private Long id;
}
