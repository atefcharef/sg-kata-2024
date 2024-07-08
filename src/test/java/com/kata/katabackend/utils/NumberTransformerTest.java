package com.kata.katabackend.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class NumberTransformerTest {


    @Test
    public void testTransform1() {
        assertEquals("1", NumberTransformer.transform(1));
    }

    @Test
    public void testTransform3() {
        assertEquals("FOOFOO", NumberTransformer.transform(3));
    }

    @Test
    public void testTransform5() {
        assertEquals("BARBAR", NumberTransformer.transform(5));
    }

    @Test
    public void testTransform7() {
        assertEquals("QUIX", NumberTransformer.transform(7));
    }

    @Test
    public void testTransform9() {
        assertEquals("FOO", NumberTransformer.transform(9));
    }

    @Test
    public void testTransform51() {
        assertEquals("FOOBAR", NumberTransformer.transform(51));
    }

    @Test
    public void testTransform53() {
        assertEquals("BARFOO", NumberTransformer.transform(53));
    }

    @Test
    public void testTransform33() {
        assertEquals("FOOFOOFOO", NumberTransformer.transform(33));
    }

    @Test
    public void testTransform15() {
        assertEquals("FOOBARBAR", NumberTransformer.transform(15));
    }
  
}