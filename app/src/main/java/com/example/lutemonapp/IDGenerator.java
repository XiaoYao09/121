package com.example.lutemonapp;

public class IDGenerator {
    private static IDGenerator instance;
    private int currentId = 0;

    private IDGenerator() {}

    public static IDGenerator getInstance() {
        if (instance == null) {
            instance = new IDGenerator();
        }
        return instance;
    }

    public int getNextId() {
        return currentId++;
    }
}

