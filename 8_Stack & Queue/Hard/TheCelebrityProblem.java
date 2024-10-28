// The Celebrity Problem - https://www.naukri.com/code360/problems/the-celebrity-problem_982769

// There are ‘N’ people at a party. Each person has been assigned a unique id between 0 to 'N' - 1(both inclusive). A celebrity is a person who is known to everyone but does not know anyone at the party.

// Given a helper function ‘knows(A, B)’, It will returns "true" if the person having id ‘A’ know the person having id ‘B’ in the party, "false" otherwise. Your task is to find out the celebrity at the party. Print the id of the celebrity, if there is no celebrity at the party then print -1.

// Note:
// 1. The helper function ‘knows’ is already implemented for you.
// 2. ‘knows(A, B)’ returns "false", if A doesn't know B.
// 3. You should not implement helper function ‘knows’, or speculate about its implementation.
// 4. You should minimize the number of calls to function ‘knows(A, B)’.
// 5. There are at least 2 people at the party.
// 6. At most one celebrity will exist.

// Input: 2
// Call function ‘knows(0, 1)’ // returns false
// Call function ‘knows(1, 0)’ // returns true
// Output: 0
// Explanation: In the first test case, there are 2 people at the party. When we call function knows(0,1), it returns false. That means the person having id ‘0’ does not know a person having id ‘1'. Similarly, the person having id ‘1’  knows a person having id ‘0’ as knows(1,0) returns true. Thus a person having id ‘0’ is a celebrity because he is known to everyone at the party but doesn't know anyone.

public class TheCelebrityProblem {
    public static int findCelebrity(int n) {
        int low = 0;
        int high = n - 1;
        while (low < high) {
            if (knows(low, high)) {
                low++;
            } else {
                high--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != low) {
                if (knows(low, i) || !knows(i, low)) {
                    return -1;
                }
            }
        }
        return low;
    }

    // A helper function 'knows' is assumed to be provided in the actual
    // environment. Here we define a 2D matrix to simulate the 'knows' function.
    private static int[][] M;

    public static boolean knows(int a, int b) {
        return M[a][b] == 1; // Assuming 1 means knows, 0 means does not know
    }

    public static void main(String[] args) {
        // Setup the knows matrix for 2 people
        M = new int[][] {
                { 0, 0 }, // Person 0 does not know Person 1
                { 1, 0 } // Person 1 knows Person 0
        };
        int n = M.length; // Number of people at the party
        
        System.out.println(findCelebrity(n));
        // 0
    }
}
