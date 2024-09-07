// Triangle -  https://www.naukri.com/code360/problems/triangle_6573690

public class Pattern_9 {
    public static void nTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        nTriangle(n);
        // 1
        // 2 2
        // 3 3 3
        // 4 4 4 4
        // 5 5 5 5 5
    }
}
