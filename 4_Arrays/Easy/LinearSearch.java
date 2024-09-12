// Linear Search - https://www.naukri.com/code360/problems/linear-search_624470

// You have been given a random integer array/list(ARR) of size N, and an integer X. You need to search for the integer X in the given array/list using 'Linear Search'.

//  You have been required to return the index at which X is present in the array/list. If X has multiple occurrences in the array/list, then you need to return the index at which the first occurrence of X would be encountered. In case X is not present in the array/list, then return -1.

// Input:
// int x = 12;
// int arr[] = { 1, 3, 45, 7, 2, -10, 12, 95, 3 };
// Output: 6

public class LinearSearch {
    public static int linearSearch(int arr[], int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int x = 12;
        int arr[] = { 1, 3, 45, 7, 2, -10, 12, 95, 3 };
        System.out.println(linearSearch(arr, x));
        // 6
    }
}
