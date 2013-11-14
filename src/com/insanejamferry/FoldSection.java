package com.insanejamferry;

public class FoldSection {

    private int start;
    private int end;

    public FoldSection(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public static FoldSection fromDarkSection(DarkSection darkSection, int bookHeightRatio) {
        return new FoldSection(darkSection.getFirstDark() * bookHeightRatio, (darkSection.getLastDark() + 1) * bookHeightRatio);
    }
}
