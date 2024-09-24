// Reverse Pairs - https://leetcode.com/problems/reverse-pairs/description/

// Given an integer array nums, return the number of reverse pairs in the array.
// A reverse pair is a pair (i, j) where:
// 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

public class ReversePairs {
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = low + (high - low) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    public static int countPairs(int arr[], int low, int mid, int high) {
        int count = 0;
        int i = low;
        int j = mid + 1;
        while (i <= mid) {
            while (j <= high && (long) arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
            i++;
        }
        return count;
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int temp[] = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        k = 0;
        for (int idx = low; idx <= high; idx++) {
            arr[idx] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 2, 3, 1 };
        System.out.println(reversePairs(nums));
        // 2
    }
}
