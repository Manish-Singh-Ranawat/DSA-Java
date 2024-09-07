
public class Pattern_14 {
    public static void nLetterTriangle(int n) {
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        nLetterTriangle(5);
        // A
        // B C
        // D E F
        // G H I J
        // K L M N O
    }
}
