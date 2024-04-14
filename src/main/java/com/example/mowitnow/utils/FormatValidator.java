package com.example.mowitnow.utils;

import com.example.mowitnow.Exceptions.InputFormatException;

public class FormatValidator {

    public static void validateInputFormat(String input) throws InputFormatException {
        String[] lines = input.split("\\r?\\n");
        String[] dimensions = lines[0].split("\\s+");
        if (lines.length < 3 || (lines.length % 2 != 1) || dimensions.length < 2) {
            throw new InputFormatException("Input must include at least one mower and corresponding commands.");
        }

        int pelouseWidth = Integer.parseInt(dimensions[0]);
        int pelouseHeight = Integer.parseInt(dimensions[1]);

        // Valider les dimensions de la pelouse
        if (!lines[0].matches("\\d+ \\d+")) {
            throw new InputFormatException("The lawn dimensions must be two positive integers.");
        }

        // Valider les données de chaque tondeuse
        for (int i = 1; i < lines.length; i += 2) {
            if (!lines[i].matches("\\d+ \\d+ [NESW]")) {
                throw new InputFormatException("Mower position and orientation must be in the format 'X Y O', where O is one of N, E, S, W.");
            }

            String[] position = lines[i].split("\\s+");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);

            if (x < 0 || x > pelouseWidth || y < 0 || y > pelouseHeight) {
                throw new InputFormatException("Mower position out of bounds.");
            }
            
            if (!lines[i + 1].matches("[ADG]+")) {
                throw new InputFormatException("Mower commands must only include characters A, D, or G.");
            }
        }
    }
}

