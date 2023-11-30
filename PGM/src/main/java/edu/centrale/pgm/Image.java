/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centrale.pgm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author alex4
 */
public class Image {
    private int largeur;
    private int hauteur;
    
    private int max_gray;
    
    private ArrayList<Integer> pixels;

    public Image() {
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getMax_gray() {
        return max_gray;
    }

    public void setMax_gray(int max_gray) {
        this.max_gray = max_gray;
    }

    public ArrayList<Integer> getPixels() {
        return pixels;
    }

    public void setPixels(ArrayList<Integer> pixels) {
        this.pixels = pixels;
    }

    public void readImage(String file_name)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file_name));
        
        // Lire l'en-tête PGM
        br.readLine(); // P2
        br.readLine(); // Commentaire
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(tokenizer.nextToken());
        int height = Integer.parseInt(tokenizer.nextToken());
        
        this.largeur = width;
        this.hauteur = height;
        
        // Ignorer la ligne de valeur maximale (255)
        br.readLine();
        this.max_gray = 255;
        
        ArrayList<Integer> pixels = new ArrayList<Integer>();
        
        String line;
        
        while ((line = br.readLine()) != null){
            tokenizer = new StringTokenizer(line);
            while(tokenizer.hasMoreTokens()){
                pixels.add(Integer.parseInt(tokenizer.nextToken()));
                
            }
        }
        
        this.pixels = pixels;

        br.close();
        
    }
    
    public void writePGM(String file_name) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file_name));

        // Écrire l'en-tête PGM
        bw.write("P2\n# Image PGM\n" + this.largeur + " " + this.hauteur + "\n255\n");

        // Écrire les pixels
        for (int i = 0; i < pixels.size(); i++) {
            bw.write(this.pixels.get(i) + " ");
            
            // Ajouter un retour à la ligne toutes les 70 caractères
            if ((i + 1) % 70 == 0) {
                bw.write("\n");
            }
        }

        bw.close();
    }

    
    
    
}
