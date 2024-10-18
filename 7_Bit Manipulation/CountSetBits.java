// Set Bits - https://www.naukri.com/code360/problems/set-bits_1164179?interviewProblemRedirection=true&practice_topic%5B%5D=Bit%20Manipulation 

// Write a program to count the number of 1's in the binary representation of an integer.

// Input : 9
// Output : 2
// Explanation : Binary Representation of 9 is 1001.

public class CountSetBits {
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(countSetBits(n));
        // 2
    }
}
