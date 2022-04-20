package algo.standard.algorithms;

import algo.util.Util;

import java.util.Arrays;

/**
 * Find the smallest card. Swap it with the first card.
 * Find the second-smallest card. Swap it with the second card.
 * Find the third-smallest card. Swap it with the third card.
 * Repeat finding the next-smallest card, and swapping it into the correct position until the array is sorted.
 * This algorithm is called selection sort because it repeatedly selects the next-smallest element and swaps it into place.
 * Complexity: O(n*n), i.e. n square
 */
public class SortSelection {

    public static void main(String[] args){
        int[] arrayForSort = {3,1,7,12,6,7};
        selectionSort(arrayForSort);
        System.out.println(Arrays.toString(arrayForSort));
    }

    public static void selectionSort(int[] a) {
        for (int i=0; i<a.length-1; i++) {
            int minIndex = Util.minIndex(a, i);
            Util.swapInt(a, i, minIndex);
        }
    }
}
