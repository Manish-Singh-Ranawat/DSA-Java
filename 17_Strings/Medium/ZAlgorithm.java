// Z Algorithm - https://www.naukri.com/code360/problems/z-algorithm_1112619?leftPanelTabValue=PROBLEM

// You’re given a string S of length N and a string P of length M. Your task is to find the number of occurrences of P in S in linear time.

// For example: If S = "ababa", and P = "ab", then "ab" occurs twice in "ababa".

// Note: The string only consists of lowercase English alphabets.

// Input: s = "ababa", p = "ab", n = 5, m = 2
// Output : 2
// Explanation : "ab" occurs two times in "ababa". The first occurrence is from position 1 to position 2 and the second occurrence is from position 4 to position 5.

public class ZAlgorithm {
    public static int zAlgorithm(String s, String p, int n, int m) {
        String concat = p + "$" + s;
        int len = concat.length();
        int[] Z = computeZ(concat);
        int count = 0;
        for (int i = 0; i < len; ++i) {
            if (Z[i] == m)
                count++;
        }
        return count;
    }

    private static int[] computeZ(String s) {
        int n = s.length();
        int Z[] = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; ++i) {
            if (i > r) {
                l = r = i;
                while (r < n && s.charAt(r - l) == s.charAt(r))
                    r++;
                Z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (Z[k] < r - i + 1)
                    Z[i] = Z[k];
                else {
                    l = i;
                    while (r < n && s.charAt(r - l) == s.charAt(r))
                        r++;
                    Z[i] = r - l;
                    r--;
                }
            }
        }
        return Z;
    }

    public static void main(String[] args) {
        String s = "ababa";
        String p = "ab";
        int n = s.length();
        int m = p.length();
        System.out.println(zAlgorithm(s, p, n, m));
        // 2
    }
}
