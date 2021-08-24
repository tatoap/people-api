package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.StateDTO;

public class StateUtils {

    private static final String NAME = "São Paulo";
    private static final long STATE_ID = 1L;

    public static StateDTO createFakeDTO() {
        return StateDTO.builder()
                .id(STATE_ID)
                .name(NAME)
                .build();
    }
}
