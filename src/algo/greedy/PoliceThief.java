package algo.greedy;

import java.util.ArrayList;

/**
 * Implement a function that calculates the number of thieves that can be caught.
 * Each police officer can catch only one thief, and a police officer cannot catch a thief who is more than k units away from him.
 * The output is the maximum number of thieves that can be caught.
 */
public class PoliceThief {

    public static void main(String[] args) {
        char inputs[][] = {
                {'P', 'T', 'T', 'P', 'T'},
                {'T', 'T', 'P', 'P', 'T', 'P'},
                {'T', 'T', 'T', 'T'},
                {'P', 'P', 'P', 'P'},
                {'P', 'T', 'P', 'P'}
        };
        int inputDistance[] = {1, 2, 1, 2, 2};
        int outputs[] = {2, 3, 0, 0, 1};

        for(int i=0; i<inputs.length; i++) {
            System.out.println(policeThief(inputs[i], inputDistance[i]) == outputs[i] ? "Success" : "Error");
        }
    }

    /**
     * If we try the brute force approach, we have to check all the possible combinations of police and thief, and then return their maximum size set.
     * Such an approach hasan exponential time complexity. However, a slight tweak in the brute force method can give us an optimized solution.
     *
     * We use the greedy approach, ignoring the police officers and focusing on assigning police to thieves.
     * We get the lowest index of policeman p and thief t.
     * We take the absolute value ( |p-t|) and make an allotment if the difference of the indexes is less than k.
     * Next, we increment to the next p and t. If the difference is not less than k, increment the minimum of p and t to the next p or t.
     */
    public static int policeThief(char[] arr, int k) {
        int result = 0;
        ArrayList<Integer> thieves = new ArrayList<Integer>();
        ArrayList<Integer> police = new ArrayList<Integer>();
        int n = arr.length;
        //store indices in the respective vector
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }
        }
        int trackThieves = 0, trackPolice = 0;
        while (trackThieves < thieves.size() && trackPolice < police.size()) {
            //thieves can be caught
            if (Math.abs(thieves.get(trackThieves) - police.get(trackPolice)) <= k) {
                result++;
                trackThieves++;
                trackPolice++;
            }
            //increment the minimum index
            else if (thieves.get(trackThieves) < police.get(trackPolice)) {
                trackThieves++;
            } else {
                trackPolice++;
            }
        }
        return result;
    }

}
