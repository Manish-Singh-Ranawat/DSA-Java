
// Reverse Letter Triangle - https://www.naukri.com/code360/problems/reverse-letter-triangle_6581906

public class Pattern_15 {
    public static void nLetterTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (char ch = 'A'; ch <= 'A' + n - i; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        nLetterTriangle(n);
        // A B C D E
        // A B C D
        // A B C
        // A B
        // A
    }
}
