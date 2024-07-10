package com.kata.katabackend.utils;

import com.kata.katabackend.exceptions.NumberNotInRangeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class NumberTransformerTest {


    @Test
    void shouldThrowExceptionWhenNumberIsOutOfRange() {
        assertThrows(NumberNotInRangeException.class, () -> NumberTransformer.transform(101));
    }


    @Test
    void shouldReturnFOOFOOWhenNumberIs3() throws NumberNotInRangeException {
        assertEquals("FOOFOO", NumberTransformer.transform(3));
    }

    @Test
    void shouldReturnBARBARWhenNumberIs5() throws NumberNotInRangeException {
        assertEquals("BARBAR", NumberTransformer.transform(5));
    }

    @Test
    void shouldReturnNumberAsStringWhenNumberIs1() throws NumberNotInRangeException {
        assertEquals("1", NumberTransformer.transform(1));
    }

    @Test
    void shouldReturnNumberAsStringWhenNumberIs88() throws NumberNotInRangeException {
        assertEquals("88", NumberTransformer.transform(88));
    }



    @Test
    void shouldReturnQUIXWhenNumberIs7() throws NumberNotInRangeException {
        assertEquals("QUIX", NumberTransformer.transform(7));
    }

    @Test
    void shouldReturnFOOWhenNumberIs9() throws NumberNotInRangeException {
        assertEquals("FOO", NumberTransformer.transform(9));
    }

    @Test
    void shouldReturnFOOBARWhenNumberIs51() throws NumberNotInRangeException {
        assertEquals("FOOBAR", NumberTransformer.transform(51));
    }

    @Test
    void shouldReturnBARFOOWhenNumberIs53() throws NumberNotInRangeException {
        assertEquals("BARFOO", NumberTransformer.transform(53));
    }

    @Test
    void shouldReturnFOOFOOFOOWhenNumberIs33() throws NumberNotInRangeException {
        assertEquals("FOOFOOFOO", NumberTransformer.transform(33));
    }

    @Test
    void shouldReturnFOOBARBARWhenNumberIs15() throws NumberNotInRangeException {
        assertEquals("FOOBARBAR", NumberTransformer.transform(15));
    }
  
}