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

    public static int argMin(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int minIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int binarySearchOrInsertionPoint(int[] sorted, int t) {
        if (sorted == null) return -1;

        int lo = 0;
        int hi = sorted.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sorted[mid] == t) {
                return mid;
            } else if (sorted[mid] < t) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -(lo) - 1;
    }
}
