// Find Nth Root Of M - https://www.naukri.com/code360/problems/nth-root-of-m_1062679

// You are given two positive integers 'n' and 'm'. You have to return the 'nth' root of 'm', i.e. 'm(1/n)'. If the 'nth root is not an integer, return -1.

// Note: 'nth' root of an integer 'm' is a number, which, when raised to the power 'n', gives 'm' as a result.

// Input: ‘n’ = 3, ‘m’ = 27
// Output: 3
// Explanation: 3rd Root of 27 is 3, as (3)^3 equals 27.

public class NthRootOfNumber {

    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midPoweredN = exponentiation(mid, n, m);
            if (midPoweredN == 1) {
                return mid;
            } else if (midPoweredN == 2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int exponentiation(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m) {
                return 2;
            }
        }
        if (ans == m) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        System.out.println(NthRoot(n, m));
        // 3
    }
}
