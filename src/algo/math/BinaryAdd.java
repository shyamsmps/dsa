package algo.math;

public class BinaryAdd {

    public static void main(String[] args) {
        String[] arr = {"11", "1", "1010", "1011", "11111", "10"};
        String[] result = {"100", "10101", "100001"};
        for (int i=0; i<arr.length; i=i+2) {
            System.out.println(arr[i] + " + " + arr[i+1] + ". Actual: " + binarySumTwoNumbers(arr[i], arr[i+1]) + ", Expected: " + result[i/2]);
        }

    }

    public static String binarySumTwoNumbers(String a, String b) {
        StringBuilder output = new StringBuilder();
        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        while (i>=0 || j>=0) {
            int sum = carry;
            if (i>=0) {
                sum = sum + a.charAt(i--) - '0'; // char to int means ASCII value. for 0, its 49. SO have to subtract '0' to get actual count in int.
            }
            if (j>=0) {
                sum = sum + b.charAt(j--) - '0';
            }
            carry = sum>1 ? 1: 0;
            output.append(sum%2);
        }
        if (carry > 0) {
            output.append(carry);
        }
        return output.reverse().toString(); // better to reverse than appending in the beginning. StringBuilder is faster.
    }

}