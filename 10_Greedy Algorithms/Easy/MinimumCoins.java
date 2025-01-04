// Find Minimum Number Of Coins - https://www.naukri.com/code360/problems/find-minimum-number-of-coins_975277

// Given an infinite supply of Indian currency i.e. [1, 2, 5, 10, 20, 50, 100, 500, 1000] valued coins and an amount 'N'.

// Find the minimum coins needed to make the sum equal to 'N'. You have to return the list containing the value of coins required in decreasing order.

// Note: It is always possible to find the minimum number of coins for the given amount. So, the answer will always exist.

// Input : 13
// Output : 10 2 1
// Explanation: The minimum number of coins to change is 3 {1, 2, 10}.

import java.util.ArrayList;
import java.util.List;

public class MinimumCoins {
    public static List<Integer> minimumCoins(int n) {
        int[] currency = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };
        int m = currency.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            while (n >= currency[i]) {
                n -= currency[i];
                list.add(currency[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(minimumCoins(n));
        // [10, 2, 1]
    }
}
