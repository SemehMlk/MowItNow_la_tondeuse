package com.example.mowitnow.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mowitnow.Exceptions.InputFormatException;

@SpringBootTest
public class MowItNowServiceTest {
    
    @Autowired
    private MowItNowService service;

    @Test
    public void should_process_correctly() {
        String entree = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA";
        String expected = "1 3 N 5 1 E";
        assertEquals(expected, service.process(entree));
    }

    @Test
    public void should_throw_error_incorrect_input_format() {
        String invalidInput = "5 5\n1 N N\nGAGAGAGAA";
        assertThrows(InputFormatException.class, () -> {
            service.process(invalidInput);
        });
    }

    @Test
    public void should_throw_error_not_a_valid_command() {
        String invalidCommands = "5 5\n1 2 N\nGXGXGXGXG";
        assertThrows(InputFormatException.class, () -> {
            service.process(invalidCommands);
        });
    }

    @Test
    public void should_throw_error_initial_positions_out_of_bounds() {
        String outOfBoundsInput = "5 5\n6 6 N\nGAGAGAGAA";
        assertThrows(InputFormatException.class, () -> {
            service.process(outOfBoundsInput);
        });
    }
}
