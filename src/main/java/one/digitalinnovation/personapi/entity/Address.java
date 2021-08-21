package one.digitalinnovation.personapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Embeddable
public class Address {

    @NotBlank
    @Column(name = "address_address1")
    private String address1;

    @Column(name = "address_address2")
    private String address2;

    @NotBlank
    @Column(name = "address_number")
    private String number;

    @NotBlank
    @Column(name = "address_district")
    private String district;

    @NotBlank
    @Column(name = "address_zip_code")
    private String zipCode;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "address_city_id")
    private City city;
}
