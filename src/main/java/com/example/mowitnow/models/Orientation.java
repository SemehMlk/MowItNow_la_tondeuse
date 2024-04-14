package com.example.mowitnow.models;

public enum Orientation {
    N, E, S, W;

    public Orientation turnleft() {
        return values()[(ordinal() + 3) % 4];
    }

    public Orientation turnRight() {
        return values()[(ordinal() + 1) % 4];
    }
}