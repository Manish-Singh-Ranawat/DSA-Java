// Increasing Letter Triangle -  https://www.naukri.com/code360/problems/increasing-letter-triangle_6581897

public class Pattern_12 {
    public static void nLetterTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (char ch = 'A'; ch < 'A'+ i; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        nLetterTriangle(n);
        // A
        // A B
        // A B C
        // A B C D
        // A B C D E
    }
}
