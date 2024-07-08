package com.kata.katabackend.controllers;

import com.kata.katabackend.services.NumberTransformerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NumberTransformerController.class)
public class NumberTransformerControllerTest {

    private final String BASE_URL = "/api/v1/transform";
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NumberTransformerService numberTransformerService;

    @Test
    public void testTransformNumber() throws Exception {
        when(numberTransformerService.transformNumber(3)).thenReturn("FOO");

        mockMvc.perform(get("/api/v1/transform/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOO"));
    }


    @Test
    public void testTransformEndpoint() throws Exception {
        mockMvc.perform(get(BASE_URL).param("number", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));

        mockMvc.perform(get(BASE_URL).param("number", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOOFOO"));

        mockMvc.perform(get(BASE_URL).param("number", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("BARBAR"));

        mockMvc.perform(get(BASE_URL).param("number", "7"))
                .andExpect(status().isOk())
                .andExpect(content().string("QUIX"));

        mockMvc.perform(get(BASE_URL).param("number", "9"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOO"));

        mockMvc.perform(get(BASE_URL).param("number", "51"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOOBAR"));

        mockMvc.perform(get(BASE_URL).param("number", "53"))
                .andExpect(status().isOk())
                .andExpect(content().string("BARFOO"));

        mockMvc.perform(get(BASE_URL).param("number", "33"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOOFOOFOO"));

        mockMvc.perform(get(BASE_URL).param("number", "15"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOOBARBAR"));
    }
}