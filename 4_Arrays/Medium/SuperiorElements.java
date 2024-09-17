// Superior Elements - https://www.naukri.com/code360/problems/superior-elements_6783446

// There is an integer array ‘a’ of size ‘n’.

// An element is called a Superior Element if it is greater than all the elements present to its right.
// You must return an array all Superior Elements in the array ‘a’.

// The last element of the array is always a Superior Element. 

// Input: a = [1, 2, 3, 2], n = 4
// Output: 2 3
// Explanation: 
// a[ 2 ] = 3 is greater than a[ 3 ]. Hence it is a Superior Element. 
// a[ 3 ] = 2 is the last element. Hence it is a Superior Element.
// The final answer is in sorted order.

import java.util.ArrayList;

public class SuperiorElements {
    public static ArrayList<Integer> leaders( int a[]) {
        int n = a.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int lastMaximum = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > lastMaximum) {
                ans.add(a[i]);
                lastMaximum = a[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 2 };
        ArrayList<Integer> ans = leaders(a);
        System.out.println(ans);
        // 2 3
    }
}
