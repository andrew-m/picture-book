package com.insanejamferry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class CalcuateFolds {

    public void calculateFolds(Book book) throws IOException {
        FileInputStream fis = new FileInputStream(book.getImageFile());

        BufferedImage image = ImageIO.read(fis);

        int columnWidth = 5; // rounding issues???
        int x = 0;
        for (x = 0; x < book.getNumberOfPages(); x++) {
            BufferedImage columnImage = getColumnImage(image, columnWidth, x);
        }


    }

    private BufferedImage getColumnImage(BufferedImage image, int columnWidth, int x) {
        int bookImageHeight = image.getHeight();
        BufferedImage columnImage = new BufferedImage(columnWidth, bookImageHeight, image.getType());

        Graphics2D gr = columnImage.createGraphics();
        gr.drawImage(image, 0, 0, columnWidth, bookImageHeight, x * columnWidth, 0, x * columnWidth + columnWidth, bookImageHeight, null);
        gr.dispose();
        return columnImage;
    }
}
