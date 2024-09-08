
// Rotated Triangle - https://www.naukri.com/code360/problems/rotated-triangle_6573688

public class Pattern_20 {
    public static void nStarTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 3;
        nStarTriangle(n);
        // *
        // **
        // ***
        // **
        // *
    }
}
