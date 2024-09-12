// Second Largest Number - https://www.naukri.com/code360/problems/ninja-and-the-second-order-elements_6581960

// You have been given an array ‘a’ of ‘n’ unique non-negative integers.

// Find the second largest and second smallest element from the array.

// Return the two elements (second largest and second smallest) as another array of size 2.

// Input: ‘n’ = 5, ‘a’ = [1, 2, 3, 4, 5]
// Output: [4, 2]
// Explanation: The second largest element after 5 is 4, and the second smallest element after 1 is 2.

public class SecondOrderElements {

    public static int[] getSecondOrderElements(int n, int[] a) {
        if (n < 2) {
            return new int[] { -1, -1 };
        }
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];
            } else if (a[i] > secondLargest && a[i] != largest) {
                secondLargest = a[i];
            }
            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if (a[i] < secondSmallest && a[i] != smallest) {
                secondSmallest = a[i];
            }
        }
        return new int[] { secondLargest, secondSmallest };
    }

    public static void main(String[] args) {
        int a[] = { 4, 5, 3, 6, 7 };
        int n = a.length;
        int ans[] = getSecondOrderElements(n, a);
        System.out.println("Second Largest : " + ans[0]);
        // 6
        System.out.println("Second Smallest : " + ans[1]);
        // 4
    }
}
