// Bit Manipulation - https://www.naukri.com/code360/problems/bit-manipulation_8142533

// You have a 32-bit unsigned integer called 'num' and another integer called 'i'.

// You need to perform the following operations on the 'num' integer based on the value of 'i':
// 1. Get the bit value at the "i"th position of "num".
// 2. Set the bit at the "i"th position of "num".
// 3. Clear the bit at the "i"th position of "num".

// We are starting bits from 1 instead of 0. (1-based)

// Input : N=25  i=3
// Output : 0 29 25
// Explanation : 
// Bit at the 3rd position from LSB is 0. (1 1 0 0 1)
// The value of the given number after setting the 3rd bit is 29. (1 1 1 0 1)
// The value of the given number after clearing the 3rd bit is 25. (1 1 0 0 1)

public class BitManipulation {
    public static int[] bitManipulation(int num, int i) {
        int get = getIthBit(num, i);
        int set = setIthBit(num, i);
        int clear = clearIthBit(num, i);
        return new int[] { get, set, clear };
    }

    public static int getIthBit(int num, int i) {
        int bitMask = 1 << (i - 1);
        return (num & bitMask) == 0 ? 0 : 1;
    }

    public static int setIthBit(int num, int i) {
        int bitMask = 1 << (i - 1);
        return num | bitMask;
    }

    public static int clearIthBit(int num, int i) {
        int bitMask = ~(1 << (i - 1));
        return num & bitMask;
    }

    public static void main(String[] args) {
        int N = 25;
        int i = 3;
        int result[] = bitManipulation(N, i);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
        // 0 29 25
    }
}
