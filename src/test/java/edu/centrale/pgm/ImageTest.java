/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.centrale.pgm;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author alex4
 */
public class ImageTest {
    
    public ImageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getLargeur method, of class Image.
     */
    @Test
    @Disabled
    public void testGetLargeur() {
        System.out.println("getLargeur");
        Image instance = new Image();
        int expResult = 0;
        int result = instance.getLargeur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLargeur method, of class Image.
     */
    @Test
    @Disabled
    public void testSetLargeur() {
        System.out.println("setLargeur");
        int largeur = 0;
        Image instance = new Image();
        instance.setLargeur(largeur);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHauteur method, of class Image.
     */
    @Test
    @Disabled
    public void testGetHauteur() {
        System.out.println("getHauteur");
        Image instance = new Image();
        int expResult = 0;
        int result = instance.getHauteur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHauteur method, of class Image.
     */
    @Test
    @Disabled
    public void testSetHauteur() {
        System.out.println("setHauteur");
        int hauteur = 0;
        Image instance = new Image();
        instance.setHauteur(hauteur);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMax_gray method, of class Image.
     */
    @Test
    @Disabled
    public void testGetMax_gray() {
        System.out.println("getMax_gray");
        Image instance = new Image();
        int expResult = 0;
        int result = instance.getMax_gray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMax_gray method, of class Image.
     */
    @Test
    @Disabled
    public void testSetMax_gray() {
        System.out.println("setMax_gray");
        int max_gray = 0;
        Image instance = new Image();
        instance.setMax_gray(max_gray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPixels method, of class Image.
     */
    @Test
    @Disabled
    public void testGetPixels() {
        System.out.println("getPixels");
        Image instance = new Image();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getPixels();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPixels method, of class Image.
     */
    @Test
    @Disabled
    public void testSetPixels() {
        System.out.println("setPixels");
        ArrayList<Integer> pixels = null;
        Image instance = new Image();
        instance.setPixels(pixels);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readImage method, of class Image.
     */
    @Test
    @Disabled
    public void testReadImage() throws Exception {
        System.out.println("readImage");
        String file_name = "";
        Image instance = new Image();
        instance.readImage(file_name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeImage method, of class Image.
     */
    @Test
    @Disabled
    public void testWriteImage() throws Exception {
        System.out.println("writeImage");
        String file_name = "";
        List pixels = null;
        int largeur = 0;
        int hauteur = 0;
        Image instance = new Image();
        instance.writeImage(file_name, pixels, largeur, hauteur);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createHistogram method, of class Image.
     */
    @Test
    @Disabled
    public void testCreateHistogram() throws Exception {
        System.out.println("createHistogram");
        String outputPath = "";
        Image instance = new Image();
        instance.createHistogram(outputPath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Seuillage method, of class Image.
     */
    @Test
    @Disabled
    public void testSeuillage(int seuil, Image image) {
        image.Seuillage(seuil);
        boolean flag = true;
        
        
    }

    /**
     * Test of difference method, of class Image.
     */
    @Test
    @Disabled
    public void testDifference() {
        System.out.println("difference");
        Image other = null;
        Image instance = new Image();
        boolean expResult = false;
        boolean result = instance.difference(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
