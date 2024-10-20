package algo.sortnsearch;

import algo.util.TestCases;
import algo.util.Util;

import java.util.Arrays;

/**
 * average-case running time is also Θ(nlgn)
 * Worst case is Θ(n*n)
 */
public class SortQuick {

    public static void main(String[] args) {
        int[][] testCases = TestCases.intArraySorting();
        for (int i=0; i<testCases.length; i++) {
            int[] a = testCases[i];
            quickSort(a, 0, a.length-1);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void quickSort(int[] a, int p, int r) {
        if (p<r) {
            int q = partition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
    }

    /**
     * pivot can be random or anything. We are taking the last element as pivot.
     * by the end of this, pivot should be at its correct position.
     * elements before pivot should be smaller to equal to this and after pivot larger than this.
     * @param a
     * @param p begin index of subarray
     * @param r end index of subarray
     * @return index of pivot
     */
    public static int partition(int[] a, int p, int r) {
        int q=p, j=p; // q is the index of pivot. start with q=p and change it as we go forward.
        int pivot = a[r];
        while (j<r) {
            if (a[j] <= pivot) {
                Util.swapInt(a, q, j);
                q++;
            }
            j++;
        }
        Util.swapInt(a, q, r);
        return q;
    }
}
