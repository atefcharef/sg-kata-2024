package com.kata.katabackend.services;

import com.kata.katabackend.exceptions.NumberNotInRangeException;
import com.kata.katabackend.services.impl.NumberTransformerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class NumberTransformerServiceTest {


    @InjectMocks
    private NumberTransformerService numberTransformerService;

    @Test
    void shouldReturnTransformedNumberWhenInputIs33() throws NumberNotInRangeException {

        int input = 33;
        String expectedOutput = "FOOFOOFOO";

        String actualOutput = numberTransformerService.transformNumber(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void shouldThrowExceptionWhenNumberOutOfRange() {
        int input = 123;
        assertThrows(NumberNotInRangeException.class, () -> numberTransformerService.transformNumber(input));
    }

}