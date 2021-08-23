package one.digitalinnovation.personapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "cpf", unique = true)
    private String cpf;

    @Valid
    @JsonIgnoreProperties("people")
    @OneToMany(mappedBy = "people",
                fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
                orphanRemoval = true)
    private List<Phone> phones;

    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Valid
    @NotNull
    @Embedded
    private Address address;
}
