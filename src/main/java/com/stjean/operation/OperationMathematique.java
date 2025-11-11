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
}
