// Check whether I-th bit is set or not - https://www.naukri.com/code360/problems/check-whether-k-th-bit-is-set-or-not_5026446

// Given a number ‘N’ and a number ‘I’. Return true if ‘I’th bit of number is set, else return false.

// Input: ‘N’ = 5, ‘I’ = 1
// Output: YES
// Explanation : 5 in binary can be written as 101 and as we can see a first bit from the right of 5 is set so the answer is 'YES'.

public class CheckIfIthBitIsSet {
    public static boolean isKthBitSet(int n, int i) {
        int bitMask = 1 << (i - 1);
        return (n & bitMask) != 0;
    }

    public static void main(String[] args) {
        int n = 5;
        int i = 1;
        System.out.println(isKthBitSet(n, i));
        // true
    }
}
