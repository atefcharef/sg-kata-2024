package com.kata.katabackend.controllers;

import com.kata.katabackend.services.NumberTransformerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class NumberTransformerControllerTest {

    private final String BASE_URL = "/api/v1/transform";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NumberTransformerService numberTransformerService;

    @Test
    public void testTransformNumber_Success() throws Exception {
        // Mock the service response
        when(numberTransformerService.transformNumber(9)).thenReturn("FOO");

        mockMvc.perform(get(BASE_URL + "/9")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("FOO"));
    }

    @Test
    public void testTransformNumber_Exception() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/101")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Number must be between 0 and 100")));
    }

    @Test
    public void testTransformEndpoint() throws Exception {
        // Add your endpoint transformation tests here
        mockMvc.perform(get(BASE_URL).param("number", "3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("FOOFOO"));

        mockMvc.perform(get(BASE_URL).param("number", "5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("BARBAR"));

        mockMvc.perform(get(BASE_URL).param("number", "7"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("QUIX"));

        mockMvc.perform(get(BASE_URL).param("number", "9"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("FOO"));

        mockMvc.perform(get(BASE_URL).param("number", "51"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("FOOBAR"));

        mockMvc.perform(get(BASE_URL).param("number", "53"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("BARFOO"));

        mockMvc.perform(get(BASE_URL).param("number", "33"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("FOOFOOFOO"));

        mockMvc.perform(get(BASE_URL).param("number", "15"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("FOOBARBAR"));
    }
}
