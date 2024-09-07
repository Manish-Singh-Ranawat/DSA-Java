//  Reverse Number Triangle -  https://www.naukri.com/code360/problems/reverse-number-triangle_6581889

public class Pattern_11 {
    public static void nNumberTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        nNumberTriangle(5);
        // 1 2 3 4 5
        // 1 2 3 4
        // 1 2 3
        // 1 2
        // 1
    }
}
