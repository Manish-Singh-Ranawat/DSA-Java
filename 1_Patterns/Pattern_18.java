
// Reverse Star Triangle - https://www.naukri.com/code360/problems/reverse-star-triangle_6573685

public class Pattern_18 {
    public static void nStarTriangle(int n) {
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
        int n = 5;
        nStarTriangle(n);
        // *********
        //  *******
        //   *****
        //    ***
        //     *
    }

}
