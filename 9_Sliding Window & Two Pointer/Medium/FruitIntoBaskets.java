// Fruit Into Baskets - https://leetcode.com/problems/fruit-into-baskets/description/

// You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

// You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

// You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
// Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
// Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
// Given the integer array fruits, return the maximum number of fruits you can pick.

// Input: fruits = [0,1,2,2]
// Output: 3
// Explanation: We can pick from trees [1,2,2].
// If we had started at the first tree, we would only pick from trees [0,1].

import java.util.HashMap;

public class FruitIntoBaskets {
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxFruits = 0;
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2) {
                if (map.get(fruits[l]) == 1) {
                    map.remove(fruits[l]);
                } else {
                    map.put(fruits[l], map.get(fruits[l]) - 1);
                }
                l++;
            } else {
                maxFruits = Math.max(maxFruits, r - l + 1);
            }
            r++;
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int[] fruits = { 0, 1, 2, 2 };
        System.out.println(totalFruit(fruits));
        // 3
    }
}
