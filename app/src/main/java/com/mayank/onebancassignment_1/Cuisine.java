package com.mayank.onebancassignment_1;

public class Cuisine {
    private String name;
    private int imageResId;

    public Cuisine(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}