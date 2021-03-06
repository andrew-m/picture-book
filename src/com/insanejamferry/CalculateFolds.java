package com.insanejamferry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculateFolds {

    public Folds calculateFolds(Book book) throws IOException {
        FileInputStream fis = new FileInputStream(book.getImageFile());

        BufferedImage originalImage = ImageIO.read(fis);
        // a bit memory intensive this works -Xmx2048m -Xms256m
        Image scaledInstance = originalImage.getScaledInstance(book.getNumberOfSheets(), book.getHeightInMillimetres(), Image.SCALE_SMOOTH);
        BufferedImage image = new BufferedImage(book.getNumberOfSheets(), book.getHeightInMillimetres(), Image.SCALE_REPLICATE);
        Graphics graphics = image.getGraphics();
        graphics.drawImage(scaledInstance, 0, 0, null);
        graphics.dispose();

//        File output = new File("test/images/output/ahh.png");
//        output.createNewFile();
//        ImageIO.write(image, "png", output);


        FoldSection [] foldSections = new FoldSection[book.getNumberOfSheets()];

        int columnWidth = 1;
        int sectionNumber = 0;
        for (int x = 0; x < book.getNumberOfSheets(); x++) {
            BufferedImage columnImage = getColumnImage(image, columnWidth, x);

            List<DarkSection> darkPoints = getDarkSections(columnImage);
            if (darkPoints.isEmpty()) {
                foldSections[x] = null;
            } else {
                if (darkPoints.size() <= sectionNumber) {
                    sectionNumber = 0;
                }
                foldSections[x] = FoldSection.fromDarkSection(darkPoints.get(sectionNumber), book.getHeightInMillimetres() / image.getHeight());

                sectionNumber++;
            }
        }

        return new Folds(foldSections, book);
    }

    private BufferedImage getColumnImage(BufferedImage image, int columnWidth, int x) {
        int bookImageHeight = image.getHeight();
        BufferedImage columnImage = new BufferedImage(columnWidth, bookImageHeight, image.getType());

        Graphics2D gr = columnImage.createGraphics();
        gr.drawImage(image, 0, 0, columnWidth, bookImageHeight, x * columnWidth, 0, x * columnWidth + columnWidth, bookImageHeight, null);
        gr.dispose();
        return columnImage;
    }

    private List<DarkSection> getDarkSections(BufferedImage image) {
        // TODO values will vary between different image types

        List<DarkSection> darkSections = new ArrayList<DarkSection>();

        int start = -1;
        for (int y = 0; y < image.getHeight(); y++) {
            int rgb = image.getRGB(0, y);
            if (rgb == -16777216 && start < 0) {
                start = y;
            } else if (rgb == -1 && start >= 0) {
                darkSections.add(new DarkSection(start, y - 1));
                start = -1;
            }
        }

        if (start >= 0) {
            darkSections.add(new DarkSection(start, image.getHeight() - 1));
        }
        return darkSections;
    }
}
