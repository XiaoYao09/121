package com.example.lutemonapp;

public class BlackLutemon extends Lutemon {
    public BlackLutemon(String name) {
        super(name, "Black", 9, 0, 16, 5);
    }

    @Override
    public int getImage() {
        return R.drawable.black;
    }
}

