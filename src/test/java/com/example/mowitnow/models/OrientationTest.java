package com.example.mowitnow.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrientationTest {
    @Test
    public void should_turn_left_from_north() {
        assertEquals(Orientation.W, Orientation.N.turnleft());
    }

    @Test
    public void should_turn_right_from_north() {
        assertEquals(Orientation.E, Orientation.N.turnRight());
    }
}