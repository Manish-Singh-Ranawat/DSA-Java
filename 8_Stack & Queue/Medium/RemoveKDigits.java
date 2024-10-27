// Remove K Digits - https://leetcode.com/problems/remove-k-digits/

// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char it : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > it) {
                stack.pop();
                k--;
            }
            stack.push(it);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        int i = 0;
        while (i < res.length() - 1 && res.charAt(i) == '0') {
            i++;
        }
        return res.substring(i);
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
        // 1219
    }
}
