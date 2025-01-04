// Fractional Knapsack - https://www.naukri.com/code360/problems/fractional-knapsack_975286

// You have been given weights and values of ‘N’ items. You are also given a knapsack of size ‘W’.

// Your task is to put the items in the knapsack such that the total value of items in the knapsack is maximum.

// Note:You are allowed to break the items.

// Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.

// Output: 240.00

// Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. Total value = 100 + 60 + 80 = 240.00

import java.util.Arrays;

class Pair {
    int weight;
    int value;

    Pair(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        double maxVal = 0;
        for (int i = 0; i < n; i++) {
            if (w >= items[i].weight) {
                w -= items[i].weight;
                maxVal += items[i].value;
            } else {
                maxVal += ((double) items[i].value / (double) items[i].weight) * (double) w;
                break;
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int n = 3;
        int w = 50;
        Pair[] items = { new Pair(20, 100), new Pair(10, 60), new Pair(30, 120) };
        System.out.println(maximumValue(items, n, w));
        // 240.0
    }
}
