
//  Alpha Hill -  https://www.naukri.com/code360/problems/alpha-hill_6581921

public class Pattern_27 {
    public static void alphaHill(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            char ch;
            for (ch = 'A'; ch < 'A' + i; ch++) {
                System.out.print(ch + " ");
            }
            for (ch = (char) (ch - 2); ch >= 'A'; ch--) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        alphaHill(n);
        //       A
        //     A B A
        //   A B C B A
        // A B C D C B A
    }
}
