package com.insanejamferry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class CalcuateFolds {

    public Folds calculateFolds(Book book) throws IOException {
        FileInputStream fis = new FileInputStream(book.getImageFile());

        BufferedImage image = ImageIO.read(fis);

        FoldSection [] foldSections = new FoldSection[book.getNumberOfSheets()];

        int columnWidth = image.getWidth() / book.getNumberOfSheets(); // rounding issues???
        for (int x = 0; x < book.getNumberOfSheets(); x++) {
            BufferedImage columnImage = getColumnImage(image, columnWidth, x);

            DarkSection darkPoint = getDarkPoint(columnImage);
            if (darkPoint == null) {
                foldSections[x] = null;
            } else {
                foldSections[x] = FoldSection.fromDarkSection(darkPoint, book.getHeight() / image.getHeight());
            }
        }

        return new Folds(foldSections);
    }

    private BufferedImage getColumnImage(BufferedImage image, int columnWidth, int x) {
        int bookImageHeight = image.getHeight();
        BufferedImage columnImage = new BufferedImage(columnWidth, bookImageHeight, image.getType());

        Graphics2D gr = columnImage.createGraphics();
        gr.drawImage(image, 0, 0, columnWidth, bookImageHeight, x * columnWidth, 0, x * columnWidth + columnWidth, bookImageHeight, null);
        gr.dispose();
        return columnImage;
    }

    private DarkSection getDarkPoint(BufferedImage image) {
        // TODO values will vary between different image types

        int start = -1;
        for (int y = 0; y < image.getHeight(); y++) {
            int rgb = image.getRGB(0, y);
            if (rgb == -16777216 && start < 0) {
                start = y;
            } else if (rgb == -1 && start > 0) {
                return new DarkSection(start, y - 1);
            }
        }

        if (start >= 0) {
            return new DarkSection(start, image.getHeight() - 1);
        }
        return null;
    }
}
