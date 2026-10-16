package org.learnig;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.learnig.JumpSearch.jumpSearch;

public class Main {
     static void main(String[] args) {
        Logger.getLogger(SafeSearch.class.getName()).setLevel(Level.ALL);

        System.out.println("=== PRUEBAS DE JUMP SEARCH ===");
        int[] sortedArr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        System.out.println("Buscando 14 en Jump Search (Esperado: 6): " + jumpSearch(sortedArr, 14));
        System.out.println("Buscando 5 en Jump Search (Esperado: -1): " + jumpSearch(sortedArr, 5));
        System.out.println();

        System.out.println("=== PRUEBAS DE EXPONENTIAL SEARCH ===");
        System.out.println("Buscando 8 en Exponential Search (Esperado: 3): " + ExponentialSearch.exponentialSearch(sortedArr, 8));
        System.out.println("Buscando 100 en Exponential Search (Esperado: < 0): " + ExponentialSearch.exponentialSearch(sortedArr, 100));
        System.out.println();

        System.out.println("=== PRUEBAS DE SAFE SEARCH ===");
        System.out.println("Buscando 10 en SafeSearch - Arreglo Ordenado (Esperado: 4):");
        int res1 = SafeSearch.safeSearch(sortedArr, 10);
        System.out.println("Resultado: " + res1 + "\n");
        int[] unsortedArr = {2, 4, 6, 8, 15, 10, 12, 14, 16};
        System.out.println("Buscando 15 en SafeSearch - Arreglo Desordenado (Esperado: 4):");
        int res2 = SafeSearch.safeSearch(unsortedArr, 15);
        System.out.println("Resultado: " + res2);
    }
}