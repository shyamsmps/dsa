package algo.util;

import java.util.Arrays;

public class Util<T extends Object> {

    /**
     * swaps elements in a generic array at indices index1 and index2
     * @param arr
     * @param index1
     * @param index2
     */
    public void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * swaps elements in an array of integers at indices index1 and index2
     * @param a
     * @param i
     * @param j
     */
    public static void swapInt(int [] a, int i, int j) {
        if (i == j) {
            return;
        }
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * finds index of shortest integer in array a, starting from index s
     * @param a array of int
     * @param s index to start from
     * @return index of shortest number starting from index s
     */
    public static int minIndex(int [] a, int s) {
        int minValue = a[s];
        int minIndex = s;
        for(int i = minIndex + 1; i < a.length; i++) {
            if(a[i] < minValue) {
                minIndex = i;
                minValue = a[i];
            }
        }
        return minIndex;
    }

    /**
     * @param a array of integers
     * @return sum of all elemets in an integer array
     */
    public static int sumOfIntArray(int[] a) {
        int sum = 0;
        for (int i=0; i<a.length; i++) {
            sum+=a[i];
        }
        return sum;
    }

    /**
     * prints 2D array of integers
     * @param a
     */
    public static void print2dArray(int[][] a) {
        for(int i=0; i<a.length; i++) {
            String s = Arrays.toString(a[i]).toString()
                    .replace(",", " ")
                    .replace("[", "")
                    .replace("]", "")
                    .trim();
            System.out.println(s);
        }
    }

    /**
     *
     * @param a
     * @param start
     * @param end
     * @return sum of array elements from index start to end (elements at both indices included)
     */
    public static int arraySumByIndex(int[] a, int start, int end) {
        int sum = 0;
        for (int i= start; i<= end; i++) {
            sum += a[i];
        }
        return sum;
    }

    /**
     * Helper function to find minimum of 3 integers
     * @param a
     * @param b
     * @param c
     * @return minimum of a,b,c
     */
    public static int min(int a, int b, int c) {
        if (a <= b && a <= c) return a;
        if (b <= a && b <= c) return b;
        else return c;
    }

}
