
// Star Triangle - https://www.naukri.com/code360/problems/star-triangle_6573671

public class Pattern_17 {
    public static void nStarTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        nStarTriangle(n);
        //     *
        //    ***
        //   *****
        //  *******
        // *********
    }
}
