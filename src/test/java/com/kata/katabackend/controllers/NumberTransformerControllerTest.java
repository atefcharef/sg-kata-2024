package com.kata.katabackend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.katabackend.dtos.NumberTransformRequest;
import com.kata.katabackend.exceptions.NumberNotInRangeException;
import com.kata.katabackend.services.INumberTransformService;
import com.kata.katabackend.services.impl.NumberTransformerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(NumberTransformerController.class)
public class NumberTransformerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private INumberTransformService numberTransformerService;

    @InjectMocks
    private NumberTransformerController numberTransformerController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(numberTransformerController).build();
    }

    @Test
    void shouldReturnTransformedNumber_whenNumberIsInRangeInGetRequest() throws Exception {
        int number = 33;
        String transformedNumber = "FOOFOOFOO";

        when(numberTransformerService.transformNumber(number)).thenReturn(transformedNumber);

        mockMvc.perform(get("/{number}", number))
                .andExpect(status().isOk())
                .andExpect(content().string(transformedNumber));
    }

    @Test
    void shouldReturnBadRequest_whenNumberNotInRangeInGetRequest() throws Exception {
        int number = 101;

        when(numberTransformerService.transformNumber(number)).thenThrow(NumberNotInRangeException.class);

        mockMvc.perform(get("/{number}", number))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnTransformedNumber_whenNumberIsInRangeInPostRequest() throws Exception {
        int number = 33;
        String transformedNumber = "FOOFOOFOO";

        when(numberTransformerService.transformNumber(number)).thenReturn(transformedNumber);

        mockMvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"number\":33}"))
                .andExpect(status().isOk())
                .andExpect(content().string(transformedNumber));
    }

    @Test
    void shouldReturnBadRequest_whenNumberNotInRangeInPostRequest() throws Exception {
        int number = 101;

        when(numberTransformerService.transformNumber(number)).thenThrow(NumberNotInRangeException.class);

        mockMvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"number\":101}"))
                .andExpect(status().isBadRequest());
    }
}