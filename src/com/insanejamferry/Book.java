package com.insanejamferry;

import java.io.File;

public class Book {

    private final int numberOfSheets;
    private final int heightInMillimetres;
    private final File imageFile;
    private final int numberOfPrePages;
    private final int pageNumberOnFirstProperSheet;


    public Book(int numberOfSheets, int heightInMillimetres, File imageFile, int numberOfPrePages, int pageNumberOnFirstProperSheet) {
        this.numberOfSheets = numberOfSheets;
        this.heightInMillimetres = heightInMillimetres;
        this.imageFile = imageFile;
        this.numberOfPrePages = numberOfPrePages;
        this.pageNumberOnFirstProperSheet = pageNumberOnFirstProperSheet;
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

    public int getNumberOfPrePages() {
        return numberOfPrePages;
    }

    public int getPageNumberOnFirstProperSheet() {
        return pageNumberOnFirstProperSheet;
    }
}
