package one.digitalinnovation.personapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import one.digitalinnovation.personapi.entity.People;
import one.digitalinnovation.personapi.exception.PeopleNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static one.digitalinnovation.personapi.utils.PeopleUtils.createFakeEntity;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PeopleServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private People people;

    @MockBean
    private PeopleService peopleService;

    @BeforeEach
    public void setup() throws JsonProcessingException {

        people = createFakeEntity();

    }

    @Test
    public void expectReturns200_WhenGetPerson() throws Exception {
        mockMvc.perform(get("/v1/person"))
                .andExpect(status().isOk());
    }

    @Test
    public void expectReturns200_WhenGetPeople() throws Exception {
        when(peopleService.seekOrFail(people.getId())).thenReturn(people);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/person/{peopleId}", people.getId()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        verify(peopleService, times(1)).seekOrFail(people.getId());
    }

    @Test
    public void expectReturns204_WhenDeletePeople() throws Exception {
        when(peopleService.seekOrFail(people.getId())).thenReturn(people);

        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/person/{peopleId}", people.getId()))
                .andExpect(status().isNoContent());

        verify(peopleService, times(1)).delete(people.getId());
    }

    @Test
    public void expectReturns404_WhenGetPeopleWrongId() throws Exception {
        Long wrongId = 1000L;

        when(peopleService.seekOrFail(wrongId)).thenThrow(new PeopleNotFoundException(wrongId));

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/person/{peopleId}", wrongId))
                .andExpect(status().isNotFound());

        verify(peopleService, times(1)).seekOrFail(wrongId);
    }
}
