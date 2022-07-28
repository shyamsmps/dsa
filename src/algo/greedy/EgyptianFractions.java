package algo.greedy;

/**
 * Every positive fraction can be represented as the sum of its unique unit fractions.
 * A fraction is a unit fraction if the numerator is 1 and the denominator is a positive integer.
 * For example, 1/3 is a unit fraction. Such a representation is called Egyptian fraction.
 *
 * We can generate Egyptian fractions using the greedy algorithm.
 * For a given number of the form n/d, where d > n, first find the greatest possible unit fraction, and then perform recursion for the remaining part.
 *
 * For example, consider 6/14. We first find the ceiling of 14/6, i.e., 3, so the first unit fraction becomes 1/3
 * Now subtract 1/3 out of 6/14 and recur
 * We use the greedy algorithm because we want to reduce the fraction to a form where the denominator is greater than the numerator and the numerator doesn’t divide the denominator.
 *
 * The method is to find the biggest unit fraction we can and subtract it from the remaining fraction.
 * Doing subtractions always decreases this group of unit fractions, but it never repeats a fraction and eventually will stop, which is why we call this approach greedy.
 */
public class EgyptianFractions {

    public static void main(String[] args) {
        egyptianFractionsRecursive(2, 3);
        System.out.println();
        egyptianFractionsRecursive(4, 5);
        System.out.println();
        egyptianFractionsRecursive(6, 14);
        System.out.println();
        egyptianFractionsRecursive(14, 6);
        System.out.println();
        egyptianFractionsRecursive(10, 5);
    }

    static void egyptianFractionsRecursive(int numerator, int denominator) {
        //if either numerator or denominator is zero
        if (denominator == 0 || numerator == 0){
            return;
        }
        //numerator divides denominator -> fraction in 1/n form
        if (denominator % numerator == 0) {
            System.out.print("1/" + denominator / numerator);
            return;
        }
        //denominator can divide numerator -> number not a fraction
        if (numerator % denominator == 0) {
            System.out.print(numerator / denominator);
            return;
        }
        //if numerator greater than denominator
        if (numerator > denominator) {
            System.out.print(numerator / denominator + " , ");
            egyptianFractionsRecursive(numerator % denominator, denominator);
            return;
        }
        //denominator  greater than numerator here
        int n = denominator / numerator + 1;
        System.out.print("1/" + n + " , ");
        //call function recursively for remaining part
        egyptianFractionsRecursive(numerator * n - denominator, denominator * n);
    }

}
