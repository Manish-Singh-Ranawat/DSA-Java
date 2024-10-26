// Asteroid Collision - https://leetcode.com/problems/asteroid-collision/description/

// We are given an array asteroids of integers representing asteroids in a row.

// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroids[i]) > stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty() && Math.abs(asteroids[i]) == stack.peek()) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] res = new int[stack.size()];
        int m = res.length;
        for (int i = m - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = { 5, 10, -5 };
        int[] res = asteroidCollision(asteroids);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        // 5 10
    }
}
