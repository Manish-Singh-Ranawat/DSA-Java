// Hand of Straights - https://leetcode.com/problems/hand-of-straights/

// Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

// Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

// Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
// Output: true
// Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            pq.offer(key);
        }
        while (!pq.isEmpty()) {
            int first = pq.peek();
            for (int i = first; i < first + groupSize; i++) {
                if (!map.containsKey(i))
                    return false;
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    if (i != pq.peek())
                        return false;
                    map.remove(i);
                    pq.poll();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
        // true
    }
}
