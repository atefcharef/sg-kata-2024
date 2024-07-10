package com.kata.katabackend.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.kata.katabackend.exceptions.NumberNotInRangeException;
import com.kata.katabackend.services.impl.NumberTransformerService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NumberTransformationControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @MockBean
    private NumberTransformerService service;


    @Test
    void shouldReturnDefaultMessage_whenNumberIs33() {
        when(service.transformNumber(33)).thenReturn("FOOFOOFOO");

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/transform/33",
                String.class)).contains("FOOFOOFOO");
    }


    @Test
    void shouldReturnDefaultMessage_whenNumberIs88() {
        int number = 88;
        when(service.transformNumber(number)).thenReturn("88");

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/transform/"+number,
                String.class)).contains("88");
    }


    @Test
    void shouldReturnErrorMessage_whenNumberIsOutOfRange() {
        int number = 1002;
        when(service.transformNumber(number)).thenThrow(new NumberNotInRangeException("Number must be between 0 and 100"));

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/transform/"+number,
                String.class)).contains("Number must be between 0 and 100");
    }

}
