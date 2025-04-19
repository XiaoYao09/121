package com.example.lutemonapp;

public class WhiteLutemon extends Lutemon {
    public WhiteLutemon(String name) {
        super(name, "White", 5, 4, 20, 1);
    }
    @Override
    public int getImage() {
        return R.drawable.white;
    }
}


