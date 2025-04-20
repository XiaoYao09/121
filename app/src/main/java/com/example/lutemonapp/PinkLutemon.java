package com.example.lutemonapp;

public class PinkLutemon extends Lutemon {
    public PinkLutemon(String name) {
        super(name, "Pink", 7, 2, 18, 3);
    }
    @Override
    public int getImage() {
        return R.drawable.pink;
    }
}
