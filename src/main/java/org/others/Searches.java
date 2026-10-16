package org.others;

import java.util.ArrayList;
import java.util.List;

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

    public static int lowerBound(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >>> 1);
            if (a[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static int firstIndexOfSorted(int[] a, int target) {
        if (a == null) return -1;
        int lb = lowerBound(a, target);
        if (lb < a.length && a[lb] == target) {
            return lb;
        }
        return -1;
    }

    public static int lastIndexOfSorted(int[] a, int target) {
        if (a == null) return -1;
        int ub = lowerBound(a, target + 1);
        if (ub - 1 >= 0 && a[ub - 1] == target) {
            return ub - 1;
        }
        return -1;
    }

    public static int linearSearch2D(int[][] m, int target) {
        if (m == null) return 0;
        int count = 0;
        for (int[] ints : m) {
            if (ints != null) {
                for (int anInt : ints) {
                    if (anInt == target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static List<int[]> staircaseSearchAll(int[][] m, int target) {
        List<int[]> results = new ArrayList<>();
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return results;
        }
        int n = m.length;
        int p = m[0].length;
        int i = 0;
        int j = p - 1;
        while (i < n && j >= 0) {
            if (m[i][j] == target) {
                int tempJ = j;
                while (tempJ >= 0 && m[i][tempJ] == target) {
                    results.add(new int[] {i, tempJ});
                    tempJ--;
                }
                i++;
            }
            else if (m[i][j] > target) {
                j--;
            }
            else {
                i++;
            }
        }
        return results;
    }

    public static int[][] searchFirstAndLast2D(int[][] m, int target) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return new int[][] {{-1, -1}, {-1, -1}};
        }
        int n = m.length;
        int p = m[0].length;
        int totalElements = n * p;
        int lo = 0, hi = totalElements - 1;
        int first1D = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1);
            int val = m[mid / p][mid % p];
            if (val == target) {
                first1D = mid;
                hi = mid - 1;
            } else if (val < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (first1D == -1) {
            return new int[][] {{-1, -1}, {-1, -1}};
        }
        lo = 0;
        hi = totalElements - 1;
        int last1D = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1);
            int val = m[mid / p][mid % p];
            if (val == target) {
                last1D = mid;
                lo = mid + 1;
            } else if (val < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return new int[][] {
                {first1D / p, first1D % p},
                {last1D / p, last1D % p}
        };
    }

    public static int binarySearchIter(int[] a, int target) {
        if (a == null || a.length == 0) return -1;
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == target) return mid;
            if (a[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
