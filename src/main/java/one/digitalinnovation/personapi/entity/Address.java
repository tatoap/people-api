package one.digitalinnovation.personapi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    @Column(name = "address_address1", nullable = false)
    private String address1;

    @Column(name = "address_address2")
    private String address2;

    @Column(name = "address_number", nullable = false)
    private String number;

    @Column(name = "address_district", nullable = false)
    private String district;

    @Column(name = "address_zip_code", nullable = false)
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "address_city_id")
    private City city;
}
