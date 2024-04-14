package com.example.mowitnow.models;

public class Tondeuse {
    private int x, y;
    private Orientation orientation;
    private final Pelouse pelouse;

    public Tondeuse(int x, int y, Orientation orientation, Pelouse pelouse) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.pelouse = pelouse;
    }

    public void execute(String commandes) {
        for (char commande : commandes.toCharArray()) {
            switch (commande) {
                case 'G':
                    orientation = orientation.turnleft();
                    break;
                case 'D':
                    orientation = orientation.turnRight();
                    break;
                case 'A':
                    avancer();
                    break;
            }
        }
    }

    private void avancer() {
        int xTemp = x, yTemp = y;
        switch (orientation) {
            case N:
                yTemp++;
                break;
            case E:
                xTemp++;
                break;
            case S:
                yTemp--;
                break;
            case W:
                xTemp--;
                break;
        }
        if (pelouse.isInPelouse(xTemp, yTemp)) {
            x = xTemp;
            y = yTemp;
        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }
}
