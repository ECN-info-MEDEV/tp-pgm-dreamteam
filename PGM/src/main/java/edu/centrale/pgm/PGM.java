/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.centrale.pgm;

import java.io.IOException;

/**
 *
 * @author alex4
 */
public class PGM {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        
        Image test = new Image();
        test.readImage("baboon.pgm");
        System.out.println(test.getPixels());
    }
}
