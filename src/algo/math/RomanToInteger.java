package algo.math;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        String arr[] = {"III", "LVIII", "MCMXCIV"};
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i] + " : " + Integer.toString(romanToIntV1(arr[i])));
            System.out.println(arr[i] + " : " + Integer.toString(romanToIntV2(arr[i])));
        }

    }

    public static int romanToIntV1(String roman) {
        int number = 0;
        int last = 0;
        for (int i=0; i<roman.length(); i++) {
            int current = romanToIntMap(roman.charAt(i));
            if (last != 0 && last < current) {
                number = number - 2*last;
            }
            number += current;
            last = current;
        }
        return number;
    }

    public static int romanToIntV2(String s) {
        int number = 0;
        for (int i=0; i<s.length()-1; i++) {
            if (romanToIntMap(s.charAt(i)) < romanToIntMap(s.charAt(i+1))) {
                number -= romanToIntMap(s.charAt(i));
            } else {
                number += romanToIntMap(s.charAt(i));
            }
        }
        return number + romanToIntMap(s.charAt(s.length()-1));
    }

    public static int romanToIntMap(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return  0;
        }
    }
}
