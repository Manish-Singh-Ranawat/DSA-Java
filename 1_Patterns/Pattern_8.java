// N-Triangles - https://www.naukri.com/code360/problems/n-triangles_6573689

public class Pattern_8 {
    public static void nTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        nTriangle(n);
        // 1
        // 1 2
        // 1 2 3
        // 1 2 3 4
        // 1 2 3 4 5
    }
}
