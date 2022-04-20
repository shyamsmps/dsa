package algo.util;

public class dummy {

    public static void main(String[] args) {
        System.out.println(sqrtNewton(8));
    }

    public static int sqrtNewton(int x) {
        long r = x;
        while (r*r > x) {
            r = (r + x/r) / 2;
        }
        return (int) r;
    }

    /**
     * We want to find the largest number (num), which num*num <= x, therefore we should use the binary search to find the upper bound within the range(1,x).
     * Using upper bound of binary search
     * @param x
     * @return
     */
    public int mySqrtBinarySearch(int x) {
        int i = 1;
        int j = x;
        int ans = 0;
        while (i <=j){
            int mid = i + (j-i)/2;
            if (mid <= x/mid){
                i = mid +1;
                ans = mid;
            }
            else
                j = mid-1;
        }

        return ans;
    }

}