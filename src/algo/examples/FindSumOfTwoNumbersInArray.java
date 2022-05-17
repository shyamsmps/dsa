package algo.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSumOfTwoNumbersInArray {

    public static void main(String[] args) {
        int[] arr = {18,6,81,9,105,350,9,101,1};
        System.out.println(Arrays.toString(findSUm(arr, 700)));
        System.out.println(Arrays.toString(findSUm(arr, 206)));
        System.out.println(Arrays.toString(findSUm(arr, 90)));
        System.out.println(Arrays.toString(findSUm(arr, 102)));
    }

    // approach a.
    // sort the array using quick sort, pointers a and b in beginning and end.
    // if sum is less than a+b, b--. if sum is more, a++.

    // approach b.
    // sort and use binary search for sum-current element

    // approach c
    public static int[] findSUm(int[] arr, int sum) {
        int[] result = new int[2];
        // using hash map, iterate through array and keep checking the map as well.
        // means only one iteration. Time complexity is O(n)
        Map<Integer, Boolean> map = new HashMap<>(); // boolean because it is light. means nothing.
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(sum-arr[i])) {
                result[0] = arr[i];
                result[1] = sum-arr[i];
                break;
            } else {
                map.put(arr[i], true);
            }
        }
        return result;
    }
}
