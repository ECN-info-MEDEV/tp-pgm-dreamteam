/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.centrale.dame;

import java.util.Scanner;

/**
 *
 * @author alex4
 */
public class Dame {

    private static final int TAILLE_GRILLE = 8;

    private char[][] damier;
    private char joueurCourant;

    public Dame() {
        damier = new char[TAILLE_GRILLE][TAILLE_GRILLE];
        initialiserPions();
        joueurCourant = 'X';
    }

    private void initialiserPions() {
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                if ((i + j) % 2 == 1) {
                    if (i < 3) {
                        damier[i][j] = 'X';
                    } else if (i > 4) {
                        damier[i][j] = 'O';
                    } else {
                        damier[i][j] = '.';
                    }
                } else {
                    damier[i][j] = ' ';
                }
            }
        }
    }

    public void afficherDamier() {
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                System.out.print(damier[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void jouer() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            afficherDamier();
            System.out.println("C'est au tour du joueur " + joueurCourant);

            System.out.print("Entrez la ligne du pion à déplacer : ");
            int xDep = scanner.nextInt();
            System.out.print("Entrez la colonne du pion à déplacer : ");
            int yDep = scanner.nextInt();
            System.out.print("Entrez la ligne de la destination : ");
            int xArr = scanner.nextInt();
            System.out.print("Entrez la colonne de la destination : ");
            int yArr = scanner.nextInt();

            if (estCoupValide(xDep, yDep, xArr, yArr)) {
                deplacerPion(xDep, yDep, xArr, yArr);
                transformerEnDame(xArr, yArr);

                if (peutCapturer(xArr, yArr)) {
                    gererPriseMultiple(xArr, yArr, scanner);
                } else {
                    changerJoueur();
                }
            } else {
                System.out.println("Coup invalide. Réessayez.");
            }
        }
    }

    private void deplacerPion(int xDep, int yDep, int xArr, int yArr) {
        damier[xArr][yArr] = damier[xDep][yDep];
        damier[xDep][yDep] = ' ';
    }

    private void transformerEnDame(int x, int y) {
        if ((damier[x][y] == 'X' && x == 0) || (damier[x][y] == 'O' && x == TAILLE_GRILLE - 1)) {
            damier[x][y] = 'D';
        }
    }

    private boolean estCoupValide(int xDep, int yDep, int xArr, int yArr) {
        if (xDep < 0 || xDep >= TAILLE_GRILLE || yDep < 0 || yDep >= TAILLE_GRILLE ||
            xArr < 0 || xArr >= TAILLE_GRILLE || yArr < 0 || yArr >= TAILLE_GRILLE) {
            return false;
        }

        if (damier[xDep][yDep] != joueurCourant) {
            return false;
        }

        if (damier[xArr][yArr] != ' ') {
            return false;
        }

        return true;
    }

    private boolean peutCapturer(int x, int y) {
        return damier[x][y] == 'X' || damier[x][y] == 'O' || damier[x][y] == 'D';
    }

    private void gererPriseMultiple(int x, int y, Scanner scanner) {
        while (peutCapturer(x, y)) {
            afficherDamier();
            System.out.println("C'est au tour du joueur " + joueurCourant);

            System.out.print("Entrez la ligne de destination : ");
            int xArr = scanner.nextInt();
            System.out.print("Entrez la colonne de destination : ");
            int yArr = scanner.nextInt();

            if (estCoupValide(x, y, xArr, yArr)) {
                damier[(x + xArr) / 2][(y + yArr) / 2] = ' ';
                deplacerPion(x, y, xArr, yArr);
                x = xArr;
                y = yArr;
            } else {
                System.out.println("Coup invalide. Réessayez.");
            }
        }

        transformerEnDame(x, y);
        changerJoueur();
    }

    private void changerJoueur() {
        joueurCourant = (joueurCourant == 'X') ? 'O' : 'X';
    }

    public static void main(String[] args) {
        Dame jeu = new Dame();
        jeu.jouer();
    }
}
