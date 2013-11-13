package com.insanejamferry;

public class FoldSection {

    private double start;
    private double end;

    private FoldSection(double start, double end) {
        this.start = start;
        this.end = end;
    }

    public double getEnd() {
        return end;
    }

    public double getStart() {
        return start;
    }

    public static FoldSection fromDarkSection(DarkSection darkSection, double bookHeightRatio) {
        return new FoldSection(darkSection.getFirstDark() * bookHeightRatio, (darkSection.getLastDark() + 1) * bookHeightRatio);
    }
}
