package com.example.mowitnow.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PelouseTest {

    @Test
    public void should_test_isInPelouse() {
        Pelouse pelouse = new Pelouse(5, 5);
        assertTrue(pelouse.isInPelouse(3, 3));
        assertFalse(pelouse.isInPelouse(6, 5));
        assertFalse(pelouse.isInPelouse(-1, -1));
    }
    
}