package algo.standard.algorithms;

/**
 * Each recursive call should be on a smaller instance of the same problem, that is, a smaller sub problem.
 * The recursive calls must eventually reach a base case, which is solved without further recursion.
 */
public class Recursion {

    public static void main(String[] args) {
//        System.out.println(factorial(0));
//        System.out.println(isPalindrome("rotor", 0, 3));
        System.out.println(power(2, -3));
    }

    public static int factorial(int n) {
        if (n<0) return 0;
        if (n==0) return 1;
        return n * factorial(n-1);
    }

    public static boolean isPalindrome(String str, int begin, int end) {
        if (end <= begin) {
            return true;
        }
        if (str.charAt(begin) == str.charAt(end)) {
            return isPalindrome(str, begin+1, end-1);
        } else {
            return false;
        }
    }

    /*
    1. Base Case:Start by writing the base case. x0 = 1 for any value of x.
    2. Recursive case: n is odd, In this step, write the recursive case for which n is odd. Assume you have a function isOdd() to check if n is odd.
    3. Recursive case: n is even, In this step, write the recursive case for which n is even. Assume you have a function isEven() to check if n is even.
    4. Recursive case: n is negative, In this step, write the recursive case for which n is negative. Compute x raised to -n recursively, and return the reciprocal of that number.
     */
    public static float power(int x, int n) {
        System.out.println(n);
        if (n == 0) return 1;
        if (n < 0) return 1/power(x, n*-1);
        if (n%2 == 0) {
            float temp = power(x, n/2);
            return temp * temp;
        } else {
            return x*power(x, n-1);
        }
    }
}
