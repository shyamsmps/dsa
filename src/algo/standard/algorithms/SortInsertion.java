package algo.standard.algorithms;

import algo.util.Util;

import java.util.Arrays;

/**
 * after n iterations, we will get a sorted array from beginning till n index
 * basically, it is about inserting current element to correct position in a sorted array.
 * Call insert to insert the element that starts at index 1 into the sorted subarray in index 0.
 * Call insert to insert the element that starts at index 2 into the sorted subarray in indices 0 through 1.
 * Call insert to insert the element that starts at index 3 into the sorted subarray in indices 0 through 2.
 *
 * Running time
 * Best case when array is aready sorted: O(n)
 * Worst case (Sorted in reverse way): O(n*n)
 */
public class SortInsertion {

    public static void main(String[] args){
        int[] arrayForSort = {3,1,7,12,6,7,1};
        insertionSort(arrayForSort);
        System.out.println(Arrays.toString(arrayForSort));
    }

    public static void insertionSort(int[] a) {
        for (int i=0; i<a.length-1; i++) {
            insert(a, i);
        }
    }

    /**
     * Insert item at index+1 at correct position in array sorted from beginning till index
     * @param a
     * @param index, array is sorted till this index. current item is the one next, i.e. at index+1 position.
     */
    public static void insert(int[] a, int index) {
        int value = a[index+1];
        while (index >= 0 && a[index] > value) { // keep copying element to next index if its bigger than the value to insert
            a[index+1] = a[index]; // no need to swap. copy value at current index to next element.
            index--;
        }
        a[index+1] = value; // insert now. It will also cover case of inserting at first position.
    }
}
