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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 *
 * @author alex4
 */
public class Image {
    private int largeur;
    private int hauteur;
    
    private int max_gray;
    
    private ArrayList<Integer> pixels;

    /**
     *
     */
    public Image() {
    }

    /**
     *
     * @return
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     *
     * @param largeur
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     *
     * @return
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     *
     * @param hauteur
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     *
     * @return
     */
    public int getMax_gray() {
        return max_gray;
    }

    /**
     *
     * @param max_gray
     */
    public void setMax_gray(int max_gray) {
        this.max_gray = max_gray;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getPixels() {
        return pixels;
    }

    /**
     *
     * @param pixels
     */
    public void setPixels(ArrayList<Integer> pixels) {
        this.pixels = pixels;
    }

    /**
     *
     * @param file_name
     * @throws IOException
     */
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
    
    /**
     *
     * @param file_name
     * @param pixels
     * @throws IOException
     */
    public void writeImage(String file_name, List pixels, int largeur, int hauteur) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file_name));

        // Écrire l'en-tête PGM
        bw.write("P2\n# Image PGM\n" + largeur + " " + hauteur + "\n255\n");
        
        int nb_car = 0;

        // Écrire les pixels
        for (int i = 0; i < pixels.size(); i++) {
            nb_car += pixels.get(i).toString().length() + 1 ;
            
            
            // Ajouter un retour à la ligne toutes les 70 caractères
            if (nb_car >= 70) {
                bw.write("\n");
                nb_car = 0;
            }
            
            if((i%largeur == 0) && (nb_car <70)){
                bw.write("\n");
                nb_car = 0;
            }
            
            bw.write(pixels.get(i) + " ");
        }

        bw.close();
    }
    
    /**
     *
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public void createHistogram(String inputPath, String outputPath) throws IOException {
        // Lire l'image PGM

        // Calculer l'histogramme
        ArrayList<Integer> histogram = new ArrayList<>(Collections.nCopies(256, 0));
        for (int pixel : pixels) {
            histogram.set(pixel, histogram.get(pixel) + 1);
        }

        // Normaliser l'histogramme pour tenir dans l'image
        int maxValue = Collections.max(histogram);
        List<Integer> normalizedHistogram = histogram.stream()
                .map(value -> (int) ((double) value / maxValue * 255))
                .collect(Collectors.toList());

        System.out.println(normalizedHistogram);
        
        ArrayList<Integer> histo = new ArrayList<Integer>(Collections.nCopies(256*256, 255));
        
        for(int i=0; i<normalizedHistogram.size(); i++){
            for(int j=0; j<normalizedHistogram.get(i);j++){
                histo.set(256*256-(256-i-1)-256*j , 0);
            }
        }
        System.out.println(histo);
        
        

        // Écrire l'histogramme dans une nouvelle image PGM
        writeImage(outputPath, histo, 256, 256);
    }

    /**
     *
     * @param seuil
     */
    public void Seuillage(int seuil){
        for(int i=0; i<pixels.size(); i++){
            if(pixels.get(i) <= seuil){
                pixels.set(i, 0);
            } else {
                pixels.set(i, 255);
            }
        }
    }
    
    public boolean difference(Image other){
        
        int length = this.pixels.size();
        ArrayList otherPixels = other.getPixels();
        if(length != otherPixels.size()){
            return false;
        } else {
            for(int i=0; i<length;i++){
                if(pixels.get(i) != otherPixels.get(i)){
                    return false;
                }
            }
        }
        return true;
    }

    
    
    
}
