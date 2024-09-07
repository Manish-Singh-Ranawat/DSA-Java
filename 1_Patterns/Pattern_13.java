// Alpha-Ramp - https://www.naukri.com/code360/problems/alpha-ramp_6581888

public class Pattern_13 {
    public static void alphaRamp(int n) {
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
            }
            ch++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        alphaRamp(n);
        // A
        // B B
        // C C C
        // D D D D
        // E E E E E
    }
}
