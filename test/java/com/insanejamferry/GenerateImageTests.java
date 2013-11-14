package com.insanejamferry;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class GenerateImageTests {

    private final static File twoLines = new File("test/images/twolinesthenone.png");

    @Test
    public void printImage() throws IOException {
        FoldSection [] foldSections = new FoldSection[7];
        Book book = new Book(7, 10, twoLines);

        foldSections[0] = new FoldSection(1,2);
        foldSections[1] = new FoldSection(3,7);
        foldSections[2] = null;
        foldSections[3] = new FoldSection(2,4);
        foldSections[4] = new FoldSection(5,7);
        foldSections[5] = new FoldSection(5,10);
        foldSections[6] = new FoldSection(0,10);

        Folds folds = new Folds(foldSections, book);

        ImageGenerator imageGenerator = new ImageGenerator(folds);

        File file = new File("test/images/output/test1.png");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        imageGenerator.generateOutput(file);
    }
}
