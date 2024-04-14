package com.example.mowitnow.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TondeuseTest {
    
    @Test
    public void should_tondeuse_execute_correctly() {
        Pelouse pelouse = new Pelouse(5, 5);
        Tondeuse tondeuse = new Tondeuse(1, 2, Orientation.N, pelouse);
        tondeuse.execute("GAGAGAGAA");
        assertEquals("1 3 N", tondeuse.toString());

        Tondeuse tondeuse2 = new Tondeuse(3, 3, Orientation.E, pelouse);
        tondeuse2.execute("AADAADADDA");
        assertEquals("5 1 E", tondeuse2.toString());
    }
}
