// Binary to Decimal - https://www.naukri.com/code360/problems/binary-to-decimal_893273

// Given a Binary Number B, find its decimal equivalent.

// Input: B = 10001000
// Output: 136

public class BinaryToDecimal {
    public static int convert(int N, String str) {
        int power = 0;
        int decimal = 0;
        while (N > 0) {
            int lastDigit = Character.getNumericValue(str.charAt(N - 1));
            decimal += Math.pow(2, power) * lastDigit;
            power++;
            N--;
        }
        return decimal;
    }

    public static void main(String[] args) {
        String str = "10001000";
        int N = str.length();
        System.out.println(convert(N, str));
        // 136
    }
}
