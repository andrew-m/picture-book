package com.insanejamferry;

import java.io.File;

public class Book {

    private final int numberOfSheets;
    private final int heightInMillimetres;
    private final File imageFile;


    public Book(int numberOfSheets, int heightInMillimetres, File imageFile) {
        this.numberOfSheets = numberOfSheets;
        this.heightInMillimetres = heightInMillimetres;
        this.imageFile = imageFile;
    }

    public File getImageFile() {
        return imageFile;
    }

    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    public int getHeightInMillimetres() {
        return heightInMillimetres;
    }
}
