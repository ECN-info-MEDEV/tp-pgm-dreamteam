/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centrale.pgm;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PGMtoRGBConverter {

    public static void main(String[] args) {
        try {
            // Load the PGM image
            Image pgmImage = new Image();
            pgmImage.readImage("baboonHisto.pgm");

            // Convert PGM to RGB
            BufferedImage rgbImage = convertPGMtoRGB(pgmImage);

            // Save the RGB image
            File output = new File("baboonHisto.png");
            ImageIO.write(rgbImage, "png", output);

            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage convertPGMtoRGB(Image pgmImage) {
        int width = pgmImage.getLargeur();
        int height = pgmImage.getHauteur();

        BufferedImage rgbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int grayValue = pgmImage.getPixels().get(y*height+x);

                // Create an RGB color using the gray value
                Color rgbColor = new Color(grayValue, grayValue, grayValue);

                // Set the RGB color to the corresponding pixel in the new image
                rgbImage.setRGB(x, y, rgbColor.getRGB());
            }
        }

        return rgbImage;
    }
}