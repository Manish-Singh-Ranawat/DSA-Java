
// Number Crown - https://www.naukri.com/code360/problems/number-crown_6581894

public class Pattern_24 {
    public static void numberCrown(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 3;
        numberCrown(n);
        // 1         1
        // 1 2     2 1
        // 1 2 3 3 2 1
    }
}
