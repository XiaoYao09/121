package com.example.lutemonapp;

public class OrangeLutemon extends Lutemon {
    public OrangeLutemon(String name) {
        super(name, "Orange", 8, 1, 17, 4);
    }
    @Override
    public int getImage() {
        return R.drawable.orange;
    }
}
