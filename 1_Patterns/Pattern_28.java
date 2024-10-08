
// Ninja And The Number Pattern - https://www.naukri.com/code360/problems/ninja-and-the-number-pattern-i_6581959

public class Pattern_28 {
    public static void getNumberPattern(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                int top = i;
                int left = j;
                int bottom = (2 * n - 2) - i;
                int right = (2 * n - 2) - j;
                int num = n - Math.min(Math.min(left, right), Math.min(top, bottom));
                System.out.print(num);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        getNumberPattern(n);
        // 4444444
        // 4333334
        // 4322234
        // 4321234
        // 4322234
        // 4333334
        // 4444444

    }
}
