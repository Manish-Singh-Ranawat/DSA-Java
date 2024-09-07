// N/2-Forest - https://www.naukri.com/code360/problems/n-2-forest_6570178

public class Pattern_2 {
    public static void nForest(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        nForest(n);
        // *
        // * *
        // * * *
        // * * * *
        // * * * * *
    }
}
