package com.insanejamferry;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FoldTestWithSingleLine {

    private final static File oneLine = new File("test/images/30by30oneline7to11.png");

    private CalcuateFolds calcuateFolds;

    @Before
    public void setup() {
        calcuateFolds = new CalcuateFolds();
    }

    @Test
    public void oneSheetWithOneLineGivesCorrectHeight() throws IOException {
        Book book = new Book(1, 60, oneLine);

        Folds folds = calcuateFolds.calculateFolds(book);

        FoldSection[] foldSections = folds.getFolds();
        assertThat(foldSections.length, is(1));

        assertThat(foldSections[0].getStart(), is(14.0));
        assertThat(foldSections[0].getEnd(), is(22.0));

    }
}
