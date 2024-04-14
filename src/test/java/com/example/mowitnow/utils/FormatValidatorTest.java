package com.example.mowitnow.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.mowitnow.Exceptions.InputFormatException;

public class FormatValidatorTest {
    
    @Test
    public void should_validate_correctly() {
        String validInput = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA";
        assertDoesNotThrow(() -> FormatValidator.validateInputFormat(validInput));
    }

    @Test
    public void should_throw_error() {
        String invalidInput = "5\n1 2 N\nGAGAGAGAA";
        assertThrows(InputFormatException.class, () -> FormatValidator.validateInputFormat(invalidInput));
    }
}
