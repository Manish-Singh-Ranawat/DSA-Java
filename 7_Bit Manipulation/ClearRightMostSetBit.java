// Clear The Rightmost Set Bit

// The problem is to find the rightmost bit of a non-negative number 'N' that is currently set (i.e., has a value of 1) in its binary representation and clear it (i.e., set it to 0).

// Return the number after clearing the rightmost set bit of 'N'. The rest of the bits should remain unchanged.

// Input : N = 5
// Output: 4
// Explanation: The binary representation of 5 is 101. After clearing the rightmost set bit, it becomes 100 which is 4.

// Input : N = 4
// Output : 0
// Explanation : The binary representation of 4 is 100. After clearing the rightmost set bit, it becomes 000 which is 0.

public class ClearRightMostSetBit {
    public static int clearBits(int N) {
        if (N == 0) {
            return 0;
        }
        return N & (N - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(clearBits(n));
        // 4
    }
}
