
// Star Diamond - https://www.naukri.com/code360/problems/star-diamond_6573686

public class Pattern_19 {
    public static void nStarDiamond(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
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
        int n = 3;
        nStarDiamond(n);
        //   *
        //  ***
        // *****
        // *****
        //  ***
        //   *
    }
}
