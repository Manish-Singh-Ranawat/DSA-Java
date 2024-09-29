// Square Root of a number - https://www.naukri.com/code360/problems/square-root-integral_893351

// You are given a positive integer ‘n’.
// Your task is to find and return its square root. If ‘n’ is not a perfect square, then return the floor value of sqrt(n).

// Input: ‘n’ = 7
// Output: 2
// Explanation: The square root of the number 7 lies between 2 and 3, so the floor value is 2.

public class SquareRoot {
    public static int sqrtN(long N) {
        long low = 0;
        long high = N;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid <= N) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) high;
    }

    public static void main(String[] args) {
        long N = 7;
        System.out.println(sqrtN(N));
        // 2
    }
}
