// Seeding - https://www.naukri.com/code360/problems/seeding_6581892

public class Pattern_3 {
    public static void seeding(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        seeding(5);
        // * * * * *
        // * * * *
        // * * *
        // * *
        // *
    }
}
