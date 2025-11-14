package algo.arrays_strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AaArrayListSyntaxPractice {

    public static void main(String [] args) {

        int[] dummy = null;
        if (dummy == null) {
            dummy = new int[2];
        }

        // array initialization
        int[] a = {1, 2, 3};
        // array to string
        System.out.println(Arrays.toString(a));
        // array to list
        List<Integer> l = listFromArray(a);
        // list of integers to list of string
        List<String> ls = l.stream().map(String::valueOf).toList();
        // list to string, only works for list of strings
        System.out.println(String.join(", ", ls));


        // custom sorting
        int[][] aa = {{2,6}, {1,8}, {5,7}, {15, 18}, {3,10}, {16, 26}, {4,5}};
        // Arrays.sort(aa); can not be used as each element need to be comparable
        Arrays.sort(aa, Comparator.comparing(entry -> entry[0]));
        System.out.println(Arrays.toString(Arrays.stream(aa).map(Arrays::toString).toArray()));


    }

    public static List<Integer> listFromArray(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .toList();
    }


}
