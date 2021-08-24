package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.CityDTO;

public class CityUtils {

    private static final String NAME = "Guarulhos";
    private static final long CITY_ID = 1L;

    public static CityDTO createFakeDTO() {
        return CityDTO.builder()
                .id(CITY_ID)
                .name(NAME)
                .state(StateUtils.createFakeDTO())
                .build();
    }
}
