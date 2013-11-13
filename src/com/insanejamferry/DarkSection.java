package com.insanejamferry;

public class DarkSection {

    private int firstDark;
    private int lastDark;

    public DarkSection(int firstDark, int lastDark) {
        this.lastDark = lastDark;
        this.firstDark = firstDark;
    }

    public int getFirstDark() {
        return firstDark;
    }

    public int getLastDark() {
        return lastDark;
    }
}
