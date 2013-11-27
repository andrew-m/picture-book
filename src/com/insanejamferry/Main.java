package com.insanejamferry;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String bookName = "puzzleheight";

        File file = new File("test/images/" + bookName  +".png");
        File outputImage = new File("test/images/output/" + bookName +".png");
        File outputCsv = new File("test/csv/" + bookName +".txt");

        Book book = puzzle(file);

        CalculateFolds calculateFolds = new CalculateFolds();

        Folds folds = calculateFolds.calculateFolds(book);

        ImageGenerator imageGenerator = new ImageGenerator(folds);
        imageGenerator.generateOutput(outputImage);

        CsvGenerator csvGenerator = new CsvGenerator(folds);
        csvGenerator.generate(outputCsv);
    }

    public static Book jheartt(File file) {
        return new Book(128, 183, file, 0, 1);
    }

    public static Book puzzle(File file) {
        return new Book(208, 183, file, 0, 1);
    }
}
