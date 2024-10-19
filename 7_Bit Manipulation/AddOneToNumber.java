// Add One to a Number

// The problem is to add 1 to a given integer 'n' without using any of the '+', '++', or '+=' operators.

// The solution should involve bitwise operations and may use other operators such as '-'.

// Input : n = -5
// Output: -4
// Explanation: The given number is -5. After adding 1, the result is -4.

// Input : n = 10
// Output : 11
// Explanation : The given number is 10. After adding 1, the result is 11.

public class AddOneToNumber {
    public static int addOne(int n) {
        return -(~n);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(addOne(n));
        // 11
    }
}
