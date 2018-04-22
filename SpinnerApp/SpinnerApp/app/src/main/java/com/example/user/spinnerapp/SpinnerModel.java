package com.example.user.spinnerapp;

public class SpinnerModel {
    private String name;
    private int image;
    private String site;

    public SpinnerModel(String name, int image, String site) {
        this.name = name;
        this.image = image;
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getSite() {
        return site;
    }
}
