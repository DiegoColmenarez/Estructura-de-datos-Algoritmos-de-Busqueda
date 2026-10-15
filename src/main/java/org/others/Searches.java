package org.others;

import java.util.Arrays;

public class Searches {

    public static int linearSearch(int[] a, int target) {
        if (a == null || a.length == 0) return -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) return i;
        }
        return -1;
    }

    public static boolean contains(int[] a, int target){
        if (a == null) return false;
        for (int j : a) {
            if (j == target) return true;
        }
        return false;
    }

    public static int count(int[] a, int target){
        var counter = 0;
        if (a == null) return counter;
        for (int j : a) {
            if (j == target) counter++;
        }
        return counter;
    }

    public static int[] removeFirstOccurrence(int[] a, int target) {
        if (a == null) return null;
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return a;
        }
        int[] result = new int[a.length - 1];
        System.arraycopy(a, 0, result, 0, index);
        System.arraycopy(a, index + 1, result, index, a.length - index - 1);

        return result;
    }
}
