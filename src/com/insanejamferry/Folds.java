package com.insanejamferry;

public class Folds {

    private FoldSection [] folds;
    private Book book;

    public Folds(FoldSection[] folds, Book book) {
        this.folds = folds;
        this.book = book;
    }

    public FoldSection[] getFolds() {
        return folds;
    }

    public Book getBook() {
        return book;
    }
}
