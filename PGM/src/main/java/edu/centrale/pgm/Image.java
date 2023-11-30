/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centrale.pgm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alex4
 */
public class Image {
    private int largeur;
    private int hauteur;
    
    private int max_gray;
    
    private int[] pixels;

    public Image() {
    }
    
    public void readImage(String file_name)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file_name));
        
        // Lire l'en-tête PGM
        br.readLine(); // P2
        br.readLine(); // Commentaire
        String[] dimensions = br.readLine().split(" ");
        int width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);
        
        this.largeur = width;
        this.hauteur = height;
        
        // Ignorer la ligne de valeur maximale (255)
        br.readLine();
        this.max_gray = 255;
        int[] pixels = new int[width * height];
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        
    }
    
    
    
}
