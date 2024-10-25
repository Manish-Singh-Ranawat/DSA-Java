// Next Smaller Element - https://www.naukri.com/code360/problems/next-smaller-element_1112581

// You are given an array 'ARR' of integers of length N. Your task is to find the next smaller element for each of the array elements.

// Next Smaller Element for an array element is the first element to the right of that element which has a value strictly smaller than that element.

// If for any array element the next smaller element does not exist, you should print -1 for that array element.

// Input : arr = [ 2, 3, 1]
// Output : [1, 1, -1]. 
// Explanation : For 2, 1 is the Next Smaller element. For 3, 1 is the Next Smaller element and for 1, there is no next smaller element hence the answer for this element is -1.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElement {
    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> nse = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr.get(i) <= stack.peek()) {
                stack.pop();
            }
            nse.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(arr.get(i));
        }
        Collections.reverse(nse);
        return nse;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 3, 1));
        int n = arr.size();
        System.out.println(nextSmallerElement(arr, n));
        // [1, 1, -1]
    }
}
