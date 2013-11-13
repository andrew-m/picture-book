package com.insanejamferry;

import java.io.File;

public class Book {

    private final int numberOfPages;
    private final double height;
    private final File imageFile;


    public Book(int numberOfPages, double height, File imageFile) {
        this.numberOfPages = numberOfPages;
        this.height = height;
        this.imageFile = imageFile;
    }

    public File getImageFile() {
        return imageFile;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
