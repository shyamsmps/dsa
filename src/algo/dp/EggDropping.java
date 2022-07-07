package algo.dp;

import algo.util.Util;

/**
 * Given a tall skyscraper and a few eggs, write a function to figure out how many tries it would take to figure out
 * which floor of the skyscraper the eggs can be dropped from without breaking. Here are some rules:
 *
 * An egg that survives a fall can be used again but a broken egg must be discarded.
 * The effect of a fall is the same for all eggs.
 * If an egg breaks when dropped from a certain floor, it would also break if dropped from a higher floor.
 * If an egg survives a fall from a certain floor, it would also survive a shorter fall.
 *
 * Assume the worst case, that you need to scan each floor to see exactly which floor it is.
 * Example, if we have just one egg, start from bottom and go till the end (last floor), the egg will break and we would know.
 * Hence, for 1 egg, it will take as many trials as the number of floors.
 *
 */
public class EggDropping {

    public static void main(String[] args) {
        int[][] testCases = {
                {2, 36, 8},
                {6,15,4},
                {8, 100, 7},
                {5, 1, 1},
                {0, 100, 0},
                {100, 0, 0},
        };
        for (int i=0; i<testCases.length; i++) {
            System.out.println(testCases[i][2] == eggDropTabular(testCases[i][0], testCases[i][1]) ? "Success" : "Error");
        }

//        int[][] testCases = {
//                {6,15},
////                {4,4}
//        };
//        for (int i=0; i<testCases.length; i++) {
//            System.out.println(eggDropTabular(testCases[i][0], testCases[i][1]));
//        }

    }

    public static int eggDropRecursive(int eggs, int floors) {
        int[][] lookupTable = new int[floors+1][eggs+1];
//        for (int i=1; i<lookupTable[1].length; i++) {
//            lookupTable[1][i]=1;
//        }
//        for(int i=1; i<lookupTable.length; i++) {
//            lookupTable[i][1] = i;
//        }
        int result = eggDropRecursive(eggs, floors, lookupTable);
        Util.print2dArray(lookupTable);
        return  result;
    }

    public static int eggDropRecursive(int eggs, int floors, int[][] lookupTable) {

        if(lookupTable[floors][eggs] != 0)
            return lookupTable[floors][eggs];

        if(eggs==0)
            return 0;
        if(floors==0)
            return 0;
        if(floors==1)
            return 1;
        if(eggs==1)
            return floors;

        int min = Integer.MAX_VALUE;
        int x, res;

        // drop eggs from each floor from 1st floor to kth floor to know which one takes less trials.
        // and consider both cases for each floor. it breaks, and it does not break.
        for (x = 1; x <= floors; x++) {
            // case 1. egg breaks. means the highest floor from where egg will not break lies below the current floor.
            // hence we have one less egg and we need to scan all floors below the current one.
            int caseEggBreaks = eggDropRecursive(eggs - 1, x - 1, lookupTable);
            // case 2. egg does not break. means the highest floor from where egg will not break is either the current one or the ones above it.
            // hence we have same number of eggs left and we need to scan all floors above it.
            int caseEggDoesntBreak = eggDropRecursive(eggs, floors - x, lookupTable);
            // Since we need to minimize the number of trials in worst case, we take the maximum of two cases.
            // We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.
            res = Math.max(caseEggBreaks, caseEggDoesntBreak);
            if (res < min)
                min = res;
        }

        // return the minimum of these values plus 1. since we dropped the egg from current floor, it needs to be counted as well.
        lookupTable[floors][eggs] = min + 1;
        return min + 1;
    }

    public static int eggDropTabular(int eggs, int floors) {

        // read eggDropRecursive. similar approach.

        int[][] lookupTable = new int[floors+1][eggs+1];
        if(eggs>0 && floors>0) {
            for (int i=1; i<lookupTable[1].length; i++) {
                lookupTable[1][i]=1;
            }
            for(int i=1; i<lookupTable.length; i++) {
                lookupTable[i][1] = i;
            }
        }
        if(eggs>=2 && floors>=2) {
            for (int i = 2; i <= floors; i++) {
                for(int k = 2; k <= eggs; k++) {
                    int val = Integer.MAX_VALUE;
                    for (int j = 2; j <= i; j++) {
                        int caseEggBreaks = lookupTable[j-1][k-1];
                        int caseEggDoesntBreak = lookupTable[i-j][k];
                        int temp = 1 + Math.max(caseEggBreaks, caseEggDoesntBreak);
                        if(temp<val)
                            val = temp;
                    }
                    lookupTable[i][k] = val;
                }
            }
        }
        return lookupTable[floors][eggs];
    }

}
