// Boolean Evaluation - https://www.naukri.com/code360/problems/boolean-evaluation_1214650?

// You are given an expression 'exp' in the form of a string where operands will be : (TRUE or FALSE), and operators will be : (AND, OR or XOR).

// Now you have to find the number of ways we can parenthesize the expression such that it will evaluate to TRUE.

// As the answer can be very large, return the output modulo 1000000007.

// Note :
// 'T' will represent the operand TRUE.
// 'F' will represent the operand FALSE.
// '|' will represent the operator OR.
// '&' will represent the operator AND.
// '^' will represent the operator XOR.

// Input: exp = "T|T&F".
// Output: 1
// Explanation:
// There are total 2  ways to parenthesize this expression:
//     (i) (T | T) & (F) = F
//     (ii) (T) | (T & F) = T
// Out of 2 ways, one will result in True, so we will return 1.

public class BooleanEvaluation {
    // -- Tabulation --
    public static int evaluateExp(String exp) {
        int n = exp.length();
        int MOD = 1000000007;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i+=2) {
            dp[i][i][1] = exp.charAt(i) == 'T' ? 1 : 0;
            dp[i][i][0] = exp.charAt(i) == 'F' ? 1 : 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i >= j)
                    continue;
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    long ways = 0;
                    for (int k = i + 1; k <= j - 1; k += 2) {
                        long lt = dp[i][k - 1][1];
                        long lf = dp[i][k - 1][0];
                        long rt = dp[k + 1][j][1];
                        long rf = dp[k + 1][j][0];

                        if (exp.charAt(k) == '&') {
                            if (isTrue == 1) {
                                ways = (ways + (lt * rt) % MOD) % MOD;
                            } else {
                                ways = (ways + ((lt * rf) % MOD + (lf * rt) % MOD + (lf * rf) % MOD) % MOD) % MOD;
                            }
                        } else if (exp.charAt(k) == '|') {
                            if (isTrue == 1) {
                                ways = (ways + ((lt * rf) % MOD + (lf * rt) % MOD + (lt * rt) % MOD) % MOD) % MOD;
                            } else {
                                ways = (ways + (lf * rf) % MOD) % MOD;
                            }
                        } else {
                            if (isTrue == 1) {
                                ways = (ways + ((lt * rf) % MOD + (lf * rt) % MOD) % MOD) % MOD;
                            } else {
                                ways = (ways + ((lf * rf) % MOD + (lt * rt) % MOD) % MOD) % MOD;
                            }
                        }
                    }
                    dp[i][j][isTrue] = (int) (ways % MOD);
                }
            }
        }
        return dp[0][n - 1][1];
    }

    // -- Memoization --
    // public static int evaluateExp(String exp) {
    //     int n = exp.length();
    //     int MOD = 1000000007;
    //     int[][][] dp = new int[n][n][2];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             dp[i][j][0] = -1;
    //             dp[i][j][1] = -1;
    //         }
    //     }
    //     return helper(0, n - 1, 1, exp, MOD, dp);
    // }

    // private static int helper(int i, int j, int isTrue, String exp, int MOD, int[][][] dp) {
    //     if (i > j)
    //         return 0;
    //     if (i == j) {
    //         if (isTrue == 1)
    //             return exp.charAt(i) == 'T' ? 1 : 0;
    //         else
    //             return exp.charAt(i) == 'F' ? 1 : 0;
    //     }
    //     if (dp[i][j][isTrue] != -1)
    //         return dp[i][j][isTrue];
    //     long ways = 0;
    //     for (int k = i + 1; k <= j - 1; k += 2) {
    //         long lt = helper(i, k - 1, 1, exp, MOD, dp);
    //         long lf = helper(i, k - 1, 0, exp, MOD, dp);
    //         long rt = helper(k + 1, j, 1, exp, MOD, dp);
    //         long rf = helper(k + 1, j, 0, exp, MOD, dp);

    //         if (exp.charAt(k) == '&') {
    //             if (isTrue == 1) {
    //                 ways = (ways + (lt * rt) % MOD) % MOD;
    //             } else {
    //                 ways = (ways + ((lt * rf) % MOD + (lf * rt) % MOD + (lf * rf) % MOD) % MOD) % MOD;
    //             }
    //         } else if (exp.charAt(k) == '|') {
    //             if (isTrue == 1) {
    //                 ways = (ways + ((lt * rf) % MOD + (lf * rt) % MOD + (lt * rt) % MOD) % MOD) % MOD;
    //             } else {
    //                 ways = (ways + (lf * rf) % MOD) % MOD;
    //             }
    //         } else {
    //             if (isTrue == 1) {
    //                 ways = (ways + ((lt * rf) % MOD + (lf * rt) % MOD) % MOD) % MOD;
    //             } else {
    //                 ways = (ways + ((lf * rf) % MOD + (lt * rt) % MOD) % MOD) % MOD;
    //             }
    //         }
    //     }
    //     return dp[i][j][isTrue] = (int) (ways % MOD);
    // }

    public static void main(String[] args) {
       String exp = "T|T&F";
       System.out.println(evaluateExp(exp));
    }
}
