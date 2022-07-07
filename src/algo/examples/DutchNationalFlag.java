package algo.examples;

import algo.util.Util;

import java.util.Arrays;

/**
 * Implement a function that sorts an array of 0's, 1's and 2's.
 * This is called the Dutch national flag problem. Since the number O can be represented as the blue color, 1 as the white color, and 2 as the red color, we want the array to form the Dutch flag.
 */
public class DutchNationalFlag {

    public static void main(String[] args) {

        int[] arr = {2, 0, 0, 1, 2, 1, 0, 2, 2};
        sort(arr);

    }

    public static void sort(int[] arr) {

        int i=-1;
        int j=arr.length;
        int counter=0;
        while (counter < j) {
            if (arr[counter]==0) { // insert at the end of 1's group. increment counter
                Util.swapInt(arr, ++i, counter++);
            } else if (arr[counter]==2) { // insert at the beginning of 2's group. do not increment counter. As the last element could also be 0.
                Util.swapInt(arr, --j, counter);
            } else {
                counter++; // in case of 1, increment counter.
            }
        }

        System.out.println(Arrays.toString(arr));

    }

}