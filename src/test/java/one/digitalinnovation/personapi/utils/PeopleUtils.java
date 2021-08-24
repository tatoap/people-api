package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.entity.Address;
import one.digitalinnovation.personapi.entity.City;
import one.digitalinnovation.personapi.entity.People;
import one.digitalinnovation.personapi.entity.State;

import java.time.LocalDate;
import java.util.Collections;

public class PeopleUtils {

    private static final String FIRST_NAME = "Renato";
    private static final String LAST_NAME = "Ramos";
    private static final String CPF_NUMBER = "222.222.222-22";
    private static final Long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static State createFakeStateEntity() {
        return State.builder()
                .name("Minas Gerais")
                .build();
    }

    public static City createFakeCityEntity() {
        return City.builder()
                .name("Teófilo Otoni")
                .state(createFakeStateEntity())
                .build();
    }

    public static Address createFakeAddressEntity() {
        return Address.builder()
                .address1("Rua das Flores")
                .number("25")
                .district("Jardim das Cruzes")
                .zipCode("22222-222")
                .city(createFakeCityEntity())
                .build();
    }

    public static People createFakeEntity() {
        return People.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .address(createFakeAddressEntity())
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}

