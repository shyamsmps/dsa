package algo.greedy;

import java.util.Arrays;

/**
 * Implement a function that returns the minimum number of platforms that are required for the trains so that none of them wait.
 */
public class PlatformTrainStation {

    public static void main(String[] args) {
        int arrivals[][] = {
                {900, 940, 950, 1100, 1500, 1800},
                {200, 210, 300, 320, 350, 500},
                {200, 300, 320, 350, 500, 210}
        };
        int departures[][] = {
                {910, 1200, 1120, 1130, 1900, 2000},
                {230, 240, 320, 430, 400, 520},
                {230, 320, 430, 400, 520, 240}
        };
        int outputs[] = {3, 2, 2};
        for(int i=0; i<arrivals.length; i++) {
            System.out.println(findPlatformSquareComplexity(arrivals[i], departures[i]) == outputs[i] ? "Success" : "Error");
            System.out.println(minimumPlatformsSelf(arrivals[i], departures[i]) == outputs[i] ? "Success" : "Error");
        }
    }

    public static int minimumPlatformsSelf(int[] arrival, int[] departure) {
        // array needs to be sorted to use this approach
        Arrays.sort(arrival);
        Arrays.sort(departure);

        if (arrival.length == 0 || departure.length == 0 || arrival.length != departure.length)
            return 0;
        int total = 1; // total number of platforms needed. first entry would need one platform, hence starting with 1.
        int available = 0; // platforms in use at a given time. first train will occupy only available platform, hence starting with 0..
        int latestDeparture = 0; // latest departure of processed trains
        for (int i = 1; i < arrival.length; i++) {
            if (arrival[i] >= latestDeparture) {
                available = total - 1;
            } else {
                if (available == 0) {
                    total++;
                } else {
                    available--;
                }
            }
            if (departure[i] > latestDeparture)
                latestDeparture = departure[i];
        }
        return total;
    }

    public static int findPlatformSquareComplexity(int[] arrival, int[] departure) {
        // no sorting needed in this case
        // take each case at a time and compare it with rest of them abd find out the overlapping entries.
        // Take maximum of all iterations.
        int n = arrival.length;
        int result = 0;
        int count = 0;

        for (int index = 0; index < n; index++) {
            count = 0;
            for (int i = 1; i < n; i++) {
                if (arrival[i] >= arrival[index] && arrival[i] <= departure[index]) {
                    count++;
                }
            }
            if (result < count)
                result = count;
        }
        return result;
    }

}
