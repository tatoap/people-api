package one.digitalinnovation.personapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private String address1;

    private String address2;

    private String number;

    private String district;

    private String zipCode;

    private CityDTO city;

}
