// Decimal to Binary - https://www.naukri.com/code360/problems/decimal-to-binary_893278

// Given a n number n, compute its binary equivalent.

// Input: N = 7
// Output: 111

public class DecimalToBinary {
    public static String binaryPuzzle(int n) {
        String binary = "";
        while (n > 0) {
            int remainder = n % 2;
            binary = remainder + binary;
            n = n / 2;
        }
        return binary.equals("") ? "0" : binary;
    }

    public static void main(String[] args) {
        int num = 7;
        System.out.println(binaryPuzzle(num));
        // 111
    }
}
