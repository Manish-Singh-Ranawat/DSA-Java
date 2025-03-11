// Repeated String Match - https://leetcode.com/problems/repeated-string-match/

// Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

// Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

// Input: a = "abcd", b = "cdabcdab"
// Output: 3
// Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.

public class RepeatedStringMatchUsingRabinKarpAlgorithm {
    public static int repeatedStringMatch(String a, String b) {
        if (a.equals(b))
            return 1;
        StringBuilder sb = new StringBuilder(a);
        int count = 1;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (rabinKarp(sb.toString(), b) != -1)
            return count;
        if (rabinKarp(sb.append(a).toString(), b) != -1)
            return count + 1;
        return -1;
    }

    public static int rabinKarp(String text, String pattern) {
        if (text.isEmpty() || pattern.isEmpty() || pattern.length() > text.length()) {
            return -1;
        }
        int PRIME = 101;
        int MOD = 1000000;
        int n = text.length();
        int m = pattern.length();
        int textHash = 0, patternHash = 0, power = 1;
        for (int i = 0; i < m; i++) {
            textHash = (textHash * PRIME + text.charAt(i)) % MOD;
            patternHash = (patternHash * PRIME + pattern.charAt(i)) % MOD;
            if (i < m - 1) {
                power = (power * PRIME) % MOD;
            }
        }
        for (int i = 0; i <= n - m; i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    return i;
                }
            }
            if (i + m < n) {
                textHash = (textHash - (text.charAt(i) * power) % MOD + MOD) % MOD;
                textHash = (textHash * PRIME + text.charAt(i + m)) % MOD;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
        // 3
    }
}
