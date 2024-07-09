package com.kata.katabackend.utils;

import com.kata.katabackend.exceptions.NumberNotInRangeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class NumberTransformerTest {


    @Test
    void testTransform102() {
        assertThrows(NumberNotInRangeException.class, () -> NumberTransformer.transform(101));
    }


    @Test
    void testTransform3() {
        assertEquals("FOOFOO", NumberTransformer.transform(3));
    }

    @Test
    void testTransform5() {
        assertEquals("BARBAR", NumberTransformer.transform(5));
    }

    @Test
    void testTransform1() {
        assertEquals("1", NumberTransformer.transform(1));
    }

    @Test
    void testTransform88() {
        assertEquals("88", NumberTransformer.transform(88));
    }



    @Test
    void testTransform7() {
        assertEquals("QUIX", NumberTransformer.transform(7));
    }

    @Test
    void testTransform9() {
        assertEquals("FOO", NumberTransformer.transform(9));
    }

    @Test
    void testTransform51() {
        assertEquals("FOOBAR", NumberTransformer.transform(51));
    }

    @Test
    void testTransform53() {
        assertEquals("BARFOO", NumberTransformer.transform(53));
    }

    @Test
    void testTransform33() {
        assertEquals("FOOFOOFOO", NumberTransformer.transform(33));
    }

    @Test
    void testTransform15() {
        assertEquals("FOOBARBAR", NumberTransformer.transform(15));
    }
  
}