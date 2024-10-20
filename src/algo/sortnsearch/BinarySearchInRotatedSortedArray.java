package algo.sortnsearch;

public class BinarySearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {7,8,9,0,3,5,6};
        int[] arr2 = {1,1,1,1,1,2,3,1,1};
        System.out.println(searchRotatedArray(arr1, 0, arr1.length-1, 3));
        System.out.println(searchRotatedArray(arr2, 0, arr2.length-1, 3));
    }

    static int searchRotatedArray(int arr[], int left, int right, int n) {
        System.out.println("left: " + left + ", right: " + right);
        int mid = (left+right)/2;
        if (arr[mid] == n) {
            return mid;
        }
        if (right<left) {
            return -1;
        }

        if (arr[left] < arr[mid]) { // left half is sorted. shortest element is either at index o or on the right side.
            if (n >= arr[left] && n < arr[mid]) {
                return searchRotatedArray(arr, left, mid-1, n); // search in left
            } else {
                return searchRotatedArray(arr, mid+1, right, n); // search in right
            }
        }

        else if(arr[mid] < arr[left]) { // right half is sorted. shortest element is on the left side including mid.
            if (n > arr[mid] && n <= arr[right]) {
                return searchRotatedArray(arr, mid+1, right, n); // search in right
            } else {
                return searchRotatedArray(arr, left, mid-1, n); // search in left
            }
        }

        // corner case. In case of duplicates
        else if(arr[left] == arr[mid]) { // all repeats (1,1,1,1,1,2,3,1,1)
            if (arr[mid] != arr[right]) // If the right element is not a repeat
                return searchRotatedArray(arr, mid + 1, right, n); // search in the right half
            else { // Otherwise, search both halves
                int result = searchRotatedArray(arr, left, mid - 1, n); // Search in left
                if (result == -1)
                    return searchRotatedArray(arr, mid + 1, right, n); // Search in right
                else
                    return result;
            }
        }

        return -1;
    }

}
