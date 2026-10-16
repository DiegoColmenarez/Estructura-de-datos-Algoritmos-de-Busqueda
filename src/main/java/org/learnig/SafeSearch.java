package org.learnig;

import java.util.logging.Logger;

import static org.others.Searches.binarySearch;
import static org.others.Searches.linearSearch;

public class SafeSearch {
    private static final Logger LOGGER = Logger.getLogger(SafeSearch.class.getName());

    public static int safeSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int bsResult = binarySearch(arr, target);
        if (bsResult != -1) {
            return bsResult;
        }
        LOGGER.warning("Binary Search no encontró el elemento (" + target + "). Degradando a Linear Search.");

        int linearResult = linearSearch(arr, target);
        if (linearResult != -1) {
            LOGGER.severe(String.format("¡Falso negativo detectado! El arreglo no estaba ordenado. El elemento %d está en el índice %d.", target, linearResult));
            return linearResult;
        }
        return -1;
    }
}
