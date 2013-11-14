package com.insanejamferry;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class FoldTestWithSingleLineInEachColumn {

    private final static File oneLine = new File("test/images/30by30oneline7to11.png");
    private final static File threeLines = new File("test/images/30by30threelines.png");
    private final static File allBlackOrWhite = new File("test/images/allblackandwhite.png");

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

        assertThat(foldSections[0].getStart(), is(14));
        assertThat(foldSections[0].getEnd(), is(24));
    }

    @Test
    public void threeSheetsWithOneLineGivesCorrectHeight() throws IOException {
        Book book = new Book(3, 60, oneLine);

        Folds folds = calcuateFolds.calculateFolds(book);

        FoldSection[] foldSections = folds.getFolds();
        assertThat(foldSections.length, is(3));

        for (int x = 0; x <3; x++) {
            assertThat(foldSections[x].getStart(), is(14));
            assertThat(foldSections[x].getEnd(), is(24));
        }
    }

    @Test
    public void threeSheetsWithThreeLinesGivesCorrectHeights() throws IOException {
        Book book = new Book(3, 60, threeLines);

        Folds folds = calcuateFolds.calculateFolds(book);

        FoldSection[] foldSections = folds.getFolds();
        assertThat(foldSections.length, is(3));

        assertThat(foldSections[0].getStart(), is(4));
        assertThat(foldSections[0].getEnd(), is(14));
        assertThat(foldSections[1].getStart(), is(24));
        assertThat(foldSections[1].getEnd(), is(32));
        assertThat(foldSections[2].getStart(), is(44));
        assertThat(foldSections[2].getEnd(), is(50));
    }

    @Test
    public void allBlackAndWhite() throws IOException {
        Book book = new Book(2, 60, allBlackOrWhite);

        Folds folds = calcuateFolds.calculateFolds(book);

        FoldSection[] foldSections = folds.getFolds();
        assertThat(foldSections.length, is(2));

        assertThat(foldSections[0].getStart(), is(0));
        assertThat(foldSections[0].getEnd(), is(60));

        assertThat(foldSections[1], Is.is(nullValue()));
    }
}
