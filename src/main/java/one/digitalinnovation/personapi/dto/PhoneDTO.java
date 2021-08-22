package one.digitalinnovation.personapi.dto;

import lombok.Getter;
import lombok.Setter;
import one.digitalinnovation.personapi.enums.PhoneType;

@Getter
@Setter
public class PhoneDTO {

    private PhoneType type;

    private String number;

}
