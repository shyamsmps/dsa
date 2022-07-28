package algo.greedy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * You are given the capacity of a knapsack W and a list of​n items that each have a certain value.
 * Fractions of each item can be placed in the knapsack.
 * Your goal is to implement a function for getting the maximum possible total value of V in the knapsack.
 */
public class FractionalKnapsack {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        double[][] weights = {
                {2, 1, 6, 0.5, 0.25, 7},
                {6, 15, 0, 20},
                {12, 24, 11, 11},
                {3, 3, 1, 51},
                {1, 6, 16, 21}
        };
        double[][] values = {
                {50, 70, 100, 50, 30, 99},
                {47, 189, 4, 154},
                {21, 20, 0, 440},
                {54, 49, 287, 603},
                {57, 116, 464, 830}
        };
        int capacities[] = {10, 50, 75, 100, 0};
        double outputs[] = {303.54, 394, 481, 993, 0};
        for(int i=0; i<weights.length; i++) {
            String output = df.format(getMaxValue(weights[i], values[i], capacities[i]));
            String expected = df.format(outputs[i]);
            System.out.println(output.equals(expected) ? "Success" : "Error! Actual: " + output + ", Expected: " + expected);
        }
    }

    public static double getMaxValue(double[] w, double[] v, double c) {
        if(c<=0)
            return 0;
        // sort the items by value per weight unit and pick the ones first with max value per weight unit
        List<Item> items = new ArrayList<>();
        for(int i=0; i<w.length; i++) {
            items.add(new Item(w[i], v[i]));
        }
        items.sort(Comparator.comparing(Item::getValuePerKg).reversed());
        double currentWeight = 0;
        double currentValue = 0;
        for (Item item: items) {
            double remaining = c-currentWeight;
            if(item.weight<remaining) {
                currentWeight += item.weight;
                currentValue += item.totalValue;
            } else {
                currentValue += remaining*item.valuePerKg;
                break;
            }
        }
        return currentValue;
    }

    static class Item {
        double weight;
        double totalValue;
        Double valuePerKg;
        public Item(double w, double v) {
            weight = w;
            totalValue = v;
            valuePerKg = v/w;
        }
        public Double getValuePerKg() {
            return valuePerKg;
        }
    }

}
