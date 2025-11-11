/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stjean.operation;

/**
 *
 * @author kseme
 */
public class OperationMathematique {
    public boolean estPositif(int nombre) {
        return nombre > 0;
    }
    
  
    public long factoriel(int nombre) {
        if (nombre == 0 || nombre == 1) {
            return 1;
        }
        long resultat = 1;
        for (int i = 2; i <= nombre; i++) {
            resultat *= i;
        }
        return resultat;
    }
    
    public int[] trier(int[] listes) {
    if (listes == null || listes.length == 0) {
        return new int[0];
    }
    int[] copie = listes.clone();
    // Tri à bulles simple (décroissant)
    for (int i = 0; i < copie.length - 1; i++) {
        for (int j = 0; j < copie.length - i - 1; j++) {
            if (copie[j] < copie[j + 1]) {
                int temp = copie[j];
                copie[j] = copie[j + 1];
                copie[j + 1] = temp;
            }
        }
    }
    return copie;
}
}
