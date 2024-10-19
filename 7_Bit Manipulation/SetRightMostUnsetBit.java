// Set The Rightmost Unset Bit - https://www.naukri.com/code360/problems/set-the-rightmost-unset-bit_8160456

// The problem is to find the rightmost bit of a non-negative number 'N' that is currently unset (i.e., has a value of 0) in its binary representation and set it to 1.

// Return the number after setting the rightmost unset bit of 'N'. If there are no unset bits in N's binary representation, then the number should remain unchanged.

// Input : N = 5
// Output: 7
// Explanation: The binary representation of 5 is 101. After setting the rightmost unset bit it becomes 111 which is 7.

// Input : 7
// Output : 7
// Explanation : The binary representation of 7 is 111. As there is no unset bit it remains the same.

public class SetRightMostUnsetBit {
    public static int setBits(int N) {
        if ((N & (N + 1)) == 0) {
            return N;
        }
        return N | (N + 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(setBits(n));
        // 7
    }
}
