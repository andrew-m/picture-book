package com.insanejamferry;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("test/images/jandt.png");
        File outputImage = new File("test/images/output/jandt.png");
        File outputCsv = new File("test/csv/jandt.txt");

        Book book = new Book(128, 118, file, 0, 1);

        CalculateFolds calculateFolds = new CalculateFolds();

        Folds folds = calculateFolds.calculateFolds(book);

        ImageGenerator imageGenerator = new ImageGenerator(folds);
        imageGenerator.generateOutput(outputImage);

        CsvGenerator csvGenerator = new CsvGenerator(folds);
        csvGenerator.generate(outputCsv);
    }
}
