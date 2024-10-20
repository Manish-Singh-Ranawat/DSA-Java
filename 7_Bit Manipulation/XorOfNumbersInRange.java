// L to R XOR - https://www.naukri.com/code360/problems/l-to-r-xor_8160412

// You are given two numbers 'L' and 'R'.
// Find the XOR of the elements in the range [L, R].

// Input : 'L' = 1 and ‘R’ = 5.
// Output : 1.

public class XorOfNumbersInRange {
    public static int findXOR(int L, int R) {
        return xorFrom1ToN(L - 1) ^ xorFrom1ToN(R);
    }

    public static int xorFrom1ToN(int N) {
        if (N % 4 == 1) {
            return 1;
        } else if (N % 4 == 2) {
            return N + 1;
        } else if (N % 4 == 3) {
            return 0;
        } else {
            return N;
        }
    }

    public static void main(String[] args) {
        int l = 1;
        int r = 5;
        System.err.println(findXOR(l, r));
        // 1
    }
}
