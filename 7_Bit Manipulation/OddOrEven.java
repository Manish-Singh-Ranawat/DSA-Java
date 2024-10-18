// Odd Even - https://www.naukri.com/code360/problems/odd-even_7993579

// You are given an integer 'N'.

// Return 'odd' if the given number 'N' is odd, else return 'even'.

// Input : N = 5
// Output: odd

public class OddOrEven {
    public static String oddEven(int N) {
        return (N & 1) == 0 ? "even" : "odd";
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(oddEven(N));
        // odd
    }
}
