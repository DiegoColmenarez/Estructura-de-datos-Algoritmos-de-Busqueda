package org.others;

import java.util.Arrays;
import java.util.Random;
import static org.others.Searches.*;

public class Main {
    static void main(String[] args) {
        int SIZE = 5_000_000;
        int[] arr = new int[SIZE];
        Random rand = new Random();
        System.out.println("Generando y ordenando " + SIZE + " elementos...");
        for (int i = 0; i < SIZE; i++) {
            arr[i] = rand.nextInt(SIZE * 10);
        }
        Arrays.sort(arr);
        int target = arr[SIZE - 1];
        System.out.println("Calentando la JVM...");
        int dummy = 0;
        for (int i = 0; i < 15_000; i++) {
            dummy += linearSearch(arr, -1);
            dummy += binarySearch(arr, -1);
        }

        int corridas = 10;
        long totalLinearTime = 0;
        long totalBinaryTime = 0;

        System.out.println("Iniciando 10 corridas de prueba...\n");

        for (int i = 0; i < corridas; i++) {
            long startLin = System.nanoTime();
            int res1 = linearSearch(arr, target);
            long endLin = System.nanoTime();
            totalLinearTime += (endLin - startLin);

            long startBin = System.nanoTime();
            int res2 = binarySearch(arr, target);
            long endBin = System.nanoTime();
            totalBinaryTime += (endBin - startBin);
            dummy += res1 + res2;
        }
        long avgLinear = totalLinearTime / corridas;
        long avgBinary = totalBinaryTime / corridas;
        System.out.println("=== RESULTADOS PROMEDIO (10 Corridas) ===");
        System.out.printf("Linear Search: %,12d nanosegundos (%.2f ms)%n", avgLinear, avgLinear / 1_000_000.0);
        System.out.printf("Binary Search: %,12d nanosegundos (%.4f ms)%n", avgBinary, avgBinary / 1_000_000.0);
        System.out.println("Diferencia   : Búsqueda binaria fue ~" + (avgLinear / avgBinary) + " veces más rápida.");
        if (dummy == 0) System.out.print("");
    }
}
