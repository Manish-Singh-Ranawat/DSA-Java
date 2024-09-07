// Ninja And The Star Pattern I - https://www.naukri.com/code360/problems/ninja-and-the-star-pattern-i_6581920

public class Pattern_6 {
    public static void getStarPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        getStarPattern(n);
        // *****
        // *   *
        // *   *
        // *   *
        // *****
    }
}
