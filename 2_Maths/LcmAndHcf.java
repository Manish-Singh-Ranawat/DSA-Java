// Ninja And The LCM - https://www.naukri.com/code360/problems/lcm_4604173

// Ninja has given two numbers ‘X’ and ‘Y’. He has to find the LCM of these two numbers.
// LCM (Least Common Multiple) of two numbers is the smallest number that can be divisible by both numbers.

// Input: 'X' = 2,  ‘Y’=3
// Output: "6"
// Explanation: As “6” is the smallest number that is divisible by both 2 and 3.

public class LcmAndHcf {
    public static long LCM(int x, int y) {
        // HCF
        long hcf = 0;
        long X = x;
        long Y = y;
        while (x > 0 && y > 0) {
            if (x > y) {
                x = x % y;
            } else {
                y = y % x;
            }
        }
        if (x == 0) {
            hcf = y;
        } else {
            hcf = x;
        }
        // LCM
        long lcm = (X * Y) / hcf;
        return lcm;
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        System.out.println(LCM(x, y));
        // 6
    }
}
