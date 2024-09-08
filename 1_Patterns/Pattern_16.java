
// Alpha-Triangle -  https://www.naukri.com/code360/problems/alpha-triangle_6581429

class Pattern_16 {
    public static void alphaTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                char ch = (char) ('A' + n - j);
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        alphaTriangle(n);
        // E
        // E D
        // E D C
        // E D C B
        // E D C B A
    }
}
