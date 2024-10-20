package algo.util;

/**

 */
public class dummy {

    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};

        System.out.println(method(input));
    }

    public static int method(int[] prices) {
        int current = 0, last = 0, second_last = 0;
        for (int temp : prices) {
            second_last = last;
            last = current;
            current = temp;
            System.out.println("current: " + current + " last: " + last + " second_last: " + second_last);
        }
        return 0;
    }



}