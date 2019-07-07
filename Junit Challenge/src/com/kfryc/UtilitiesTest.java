package com.kfryc;

import org.junit.Assert;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities util;

    @org.junit.Before
    public void setup(){
        util = new Utilities();
    }


    @org.junit.Test
    public void everyNthChar() {
        assertArrayEquals(new char[] {'e','l'}, util.everyNthChar(new char[] {'h' ,'e' ,'l' ,'l', 'o'},2));
    }

    @org.junit.Test
    public void everyNthChar_longerN() {
        assertArrayEquals(new char[] {'h' ,'e' ,'l' ,'l', 'o'}, util.everyNthChar(new char[] {'h' ,'e' ,'l' ,'l', 'o'},8));
    }

    @org.junit.Test
    public void removePairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull("Did not get null returned when argument passed was null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @org.junit.Test
    public void converter() {
        assertEquals(300, util.converter(10, 5));
    }

    @org.junit.Test (expected = ArithmeticException.class)
    public void converter_zero() throws Exception{
        assertEquals(300, util.converter(10, 0));
    }

    @org.junit.Test
    public void nullIfOddLength() {
        assertNotNull(util.nullIfOddLength("even"));
        assertNull(util.nullIfOddLength("odd"));
    }
}