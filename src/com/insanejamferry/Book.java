package com.insanejamferry;

import java.io.File;

public class Book {

    private final int numberOfSheets;
    private final double height;
    private final File imageFile;


    public Book(int numberOfSheets, double height, File imageFile) {
        this.numberOfSheets = numberOfSheets;
        this.height = height;
        this.imageFile = imageFile;
    }

    public File getImageFile() {
        return imageFile;
    }

    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    public double getHeight() {
        return height;
    }
}
