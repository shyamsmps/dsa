package algo.util;

public class Util<T extends Object> {

    public void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

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

}
