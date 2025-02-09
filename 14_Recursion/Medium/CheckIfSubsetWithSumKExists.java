// Check if there exists a subset with sum K - https://www.naukri.com/code360/problems/subset-sum_630213

// You are given an array 'A' of 'N' integers. You have to return true if there exists a subset of elements of 'A' that sums up to 'K'. Otherwise, return false.

// Input: 'N' = 3, 'K' = 5, 'A' = [1, 2, 3].
// Output: true.
// Explanation: Subset [2, 3] has sum equal to 'K'. So our answer is True.

public class CheckIfSubsetWithSumKExists {
    public static boolean isSubsetPresent(int n, int k, int[] a) {
        return k == 0 ? true : subsetSumToK(0, n, a, k, 0);
    }

    private static boolean subsetSumToK(int i, int n, int a[], int k, int sum) {
        if (sum == k)
            return true;
        if (i >= n || sum > k)
            return false;
        return subsetSumToK(i + 1, n, a, k, sum + a[i]) || subsetSumToK(i + 1, n, a, k, sum);
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        int a[] = { 1, 2, 3 };
        System.out.println(isSubsetPresent(n, k, a));
        // true
    }
}
