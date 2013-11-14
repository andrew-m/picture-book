package com.insanejamferry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static javax.imageio.ImageIO.*;

public class ImageGenerator {
    private final Folds folds;

    public ImageGenerator(Folds folds) {
        this.folds = folds;
    }

    public void generateOutput(File file) throws IOException {
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        FileInputStream fis = new FileInputStream(folds.getBook().getImageFile());
        BufferedImage orginialImage = read(fis);

        FoldSection[] foldSections = folds.getFolds();
        BufferedImage outputImage = new BufferedImage(
            foldSections.length,
            folds.getBook().getHeightInMillimetres(),
            orginialImage.getType());

        for (int col = 0; col < foldSections.length; col++) {
            if (foldSections[col] != null) {
                for (int row = foldSections[col].getStart(); row < foldSections[col].getEnd(); row++) {
                    outputImage.setRGB(col, row, Color.BLUE.getRGB());
                }
            }

        }

        ImageIO.write(outputImage, "png", file);
    }
}
