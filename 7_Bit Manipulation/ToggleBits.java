// Toggle K bits - https://www.naukri.com/code360/problems/toggle-k-bits_973006

// You are given a 32-bit integer ‘N’. Your task is to toggle the rightmost ‘K’ bits in the given integer and return the new integer.

// Input : ‘N’ = 12 and ‘K’ = 2 
// Output : 15
// Explanation : The binary representation of 12 is ‘1100’, after toggling rightmost 2 bits, it becomes ‘1111’ i.e. 15. Hence, the answer is 15. 

public class ToggleBits {
    public static int toggleKBits(int n, int k) {
        int bitMask = (1 << k) - 1;
        return n ^ bitMask;
    }

    public static void main(String[] args) {
        int n = 12;
        int k = 2;
        System.out.println(toggleKBits(n, k));
        // 15
    }
}
