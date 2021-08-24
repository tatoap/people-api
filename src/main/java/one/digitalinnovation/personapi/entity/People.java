package one.digitalinnovation.personapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class People {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Valid
    @JsonIgnoreProperties("people")
    @OneToMany(mappedBy = "people",
                fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
                orphanRemoval = true)
    private List<Phone> phones;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Valid
    @Embedded
    private Address address;
}
