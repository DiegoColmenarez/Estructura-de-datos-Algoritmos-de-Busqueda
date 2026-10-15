package org.others;

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


}
