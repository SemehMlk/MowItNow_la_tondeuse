package com.example.mowitnow.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.mowitnow.models.Orientation;
import com.example.mowitnow.models.Pelouse;
import com.example.mowitnow.models.Tondeuse;
import com.example.mowitnow.utils.FormatValidator;

@Service
public class MowItNowServiceImpl implements MowItNowService {

    @Override
    public String process(String input) {
        FormatValidator.validateInputFormat(input);
        String[] lignes = input.split("\\s+");
        int index = 0;
        int pelouseWidth = Integer.parseInt(lignes[index++]);
        int pelouseHeight = Integer.parseInt(lignes[index++]);
        Pelouse pelouse = new Pelouse(pelouseWidth, pelouseHeight);

        List<Tondeuse> tondeuses = new ArrayList<>();
        while (index < lignes.length) {
            int x = Integer.parseInt(lignes[index++]);
            int y = Integer.parseInt(lignes[index++]);
            Orientation orientation = Orientation.valueOf(lignes[index++]);
            String commandes = lignes[index++];
            Tondeuse tondeuse = new Tondeuse(x, y, orientation, pelouse);
            tondeuse.execute(commandes);
            tondeuses.add(tondeuse);
        }

        return tondeuses.stream()
                .map(Tondeuse::toString)
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }

}
