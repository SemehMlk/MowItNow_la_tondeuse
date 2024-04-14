package com.example.mowitnow.models;

public class Pelouse {
    private final int width;
    private final int height;

    public Pelouse(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public boolean isInPelouse(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }
}
