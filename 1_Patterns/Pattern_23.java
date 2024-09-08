
// Binary Number Triangle - https://www.naukri.com/code360/problems/binary-number-triangle_6581890

public class Pattern_23 {
    public static void nBinaryTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        nBinaryTriangle(n);
        // 1
        // 0 1
        // 1 0 1
        // 0 1 0 1
        // 1 0 1 0 1
    }
}
