package com.insanejamferry;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FoldTestWithTwoLines {

    private final static File twoLines = new File("test/images/twolinesthenone.png");

    private CalcuateFolds calcuateFolds;

    @Before
    public void setup() {
        calcuateFolds = new CalcuateFolds();
    }

    @Test
    public void oneSheetWithOneLineGivesCorrectHeight() throws IOException {
        Book book = new Book(4, 60, twoLines, 0, 1);

        Folds folds = calcuateFolds.calculateFolds(book);

        FoldSection[] foldSections = folds.getFolds();
        assertThat(foldSections.length, is(4));

        assertThat(foldSections[0].getStart(), is(10));
        assertThat(foldSections[0].getEnd(), is(20));

        assertThat(foldSections[1].getStart(), is(40));
        assertThat(foldSections[1].getEnd(), is(50));

        assertThat(foldSections[2].getStart(), is(30));
        assertThat(foldSections[2].getEnd(), is(40));

        assertThat(foldSections[3].getStart(), is(30));
        assertThat(foldSections[3].getEnd(), is(40));


    }
}
