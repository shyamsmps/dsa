package algo.examples;

/**
 * Implement a function that returns the index of the target string in a sorted and sparsed array of strings.
 * i.e. array is sorted but there may be empty strings in between.
 */
public class SparseSearch {

    public static void main(String[] args) {

        String[] arr1  = {"", "educative", "", "", "",  "hello", "", "learning", "world", "", "", ""};
        String[] arr2  = {"", "", "", "", "",  "", "", "", "hello", "", "world", "", "", "zebra"};
        System.out.println(search(arr1, "shyam") == -1);
        System.out.println(search(arr1, "educative") == 1);
        System.out.println(search(arr1, "world") == 8);
        System.out.println(search(arr2, "zebra") == 13);


    }

    public static int search(String[] array, String  target) {

        int start = 0;
        int end = array.length-1;
        while (start <= end) {
            // find effective mid where string is not empty
            int mid = searchValidString(array, start, end);
            if (mid == -1) {
                start = mid+1;
            } else {
                int c = target.compareTo(array[mid]);
                if (c == 0) {
                    return mid;
                } else if (c > 0) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }

        return -1;

    }

    // find occurrence of a valid string, search in both directions starting from mid
    public static int searchValidString(String[] array, int start, int end) {
        int mid = (start+end)/2;
        if (!array[mid].isEmpty()) {
            return mid;
        } else {
            int i = mid-1;
            int j = mid+1;
            while (true) {
                if (i < start && j > end) {
                    return -1;
                }
                if (i >= start && !array[i].isEmpty()) {
                    return i;
                }
                if (j <= end && !array[j].isEmpty()) {
                    return j;
                }
                i--;
                j++;
            }
        }
    }

}