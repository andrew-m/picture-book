package com.insanejamferry;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class GeneratingCsvTests {

    private final static File twoLines = new File("test/images/twolinesthenone.png");


    @Test
    public void FirstSheetIsPageOne() throws IOException {
        Book book = new Book(4, 60, twoLines, 0, 1);

        FoldSection[] foldSections = new FoldSection[4];

        foldSections[0] = new FoldSection(1,2);
        foldSections[1] = new FoldSection(3,7);
        foldSections[2] = new FoldSection(2,4);
        foldSections[3] = new FoldSection(2,4);

        Folds folds = new Folds(foldSections, book);

        CsvGenerator csvGenerator = new CsvGenerator(folds);

        csvGenerator.generate(new File("test/csv/pageone.txt"));

    }

    @Test
    public void hasPageWithNoFolds() throws IOException {
        Book book = new Book(4, 60, twoLines, 0, 1);

        FoldSection[] foldSections = new FoldSection[4];

        foldSections[0] = new FoldSection(1,2);
        foldSections[1] = new FoldSection(3,7);
        foldSections[2] = null;
        foldSections[3] = new FoldSection(2,4);

        Folds folds = new Folds(foldSections, book);

        CsvGenerator csvGenerator = new CsvGenerator(folds);

        csvGenerator.generate(new File("test/csv/nofolds.txt"));

    }

    @Test
    public void bookHasPreSheets() throws IOException {
        Book book = new Book(4, 60, twoLines, 2, 2);

        FoldSection[] foldSections = new FoldSection[4];

        foldSections[0] = new FoldSection(1,2);
        foldSections[1] = new FoldSection(3,7);
        foldSections[2] = null;
        foldSections[3] = new FoldSection(2,4);

        Folds folds = new Folds(foldSections, book);

        CsvGenerator csvGenerator = new CsvGenerator(folds);

        csvGenerator.generate(new File("test/csv/pre-pages.txt"));

    }

}
