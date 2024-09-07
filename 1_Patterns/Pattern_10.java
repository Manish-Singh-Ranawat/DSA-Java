// Increasing Number Triangle - https://www.naukri.com/code360/problems/increasing-number-triangle_6581893

public class Pattern_10 {
    public static void nNumberTriangle(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        nNumberTriangle(n);
        // 1
        // 2 3
        // 4 5 6
        // 7 8 9 10
        // 11 12 13 14 15
    }
}
