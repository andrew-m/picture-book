package com.insanejamferry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;

public class CsvGenerator {
    private final Folds folds;

    public CsvGenerator(Folds folds) {
        this.folds = folds;
    }

    public void generate(File file) throws IOException {
        FoldSection[] foldSections = folds.getFolds();
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        int pageNumber = 1;
        boolean inPreSection = true;
        if (folds.getBook().getNumberOfPrePages() == 0) {
            pageNumber = folds.getBook().getPageNumberOnFirstProperSheet();
            inPreSection = false;

        }
        for (FoldSection foldSection : foldSections) {
            String start = "-";
            String end = "-";
            if (foldSection != null) {
                start = String.valueOf(foldSection.getStart());
                end = String.valueOf(foldSection.getEnd());
            }

            String pageDesc = String.valueOf(pageNumber);
            if (inPreSection) {
                pageDesc = "pre - " + pageNumber;
                if (folds.getBook().getNumberOfPrePages() == pageNumber) {
                    inPreSection = false;
                    pageNumber = folds.getBook().getPageNumberOnFirstProperSheet();
                } else {
                    pageNumber++;
                }
            }
            else {
                pageNumber += 2;
            }
            String line = MessageFormat.format("{0},{1},{2}\n", pageDesc, start, end);

            fileOutputStream.write(line.getBytes());

        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
