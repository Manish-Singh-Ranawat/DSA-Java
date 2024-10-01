// Allocate Books - https://www.naukri.com/code360/problems/allocate-books_1090540

// Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.
// There are ‘m’ number of students, and the task is to allocate all the books to the students.

// Allocate books in such a way that:
// 1. Each student gets at least one book.
// 2. Each book should be allocated to only one student.
// 3. Book allocation should be in a contiguous manner.

// You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.
// If the allocation of books is not possible, return -1.

// Input: ‘n’ = 4 ‘m’ = 2  ‘arr’ = [12, 34, 67, 90]
// Output: 113
// Explanation: All possible ways to allocate the ‘4’ books to '2' students are:

// 12 | 34, 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12’, and student two is ‘34+ 67+ 90 = 191’, so the maximum is ‘max(12, 191)= 191’.

// 12, 34 | 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 = 46’, and student two is ‘67+ 90 = 157’, so the maximum is ‘max(46, 157)= 157’.

// 12, 34, 67 | 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 +67 = 113’, and student two is ‘90’, so the maximum is ‘max(113, 90)= 113’.

// We are getting the minimum in the last case.
// Hence answer is ‘113’.

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {
    
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n)
            return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr.get(i));
            high += arr.get(i);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countStudents(arr, n, mid) > m) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public static int countStudents(ArrayList<Integer> arr, int n, int pages) {
        int count = 1;
        int noOfPages = 0;
        for (int i = 0; i < n; i++) {
            noOfPages += arr.get(i);
            if (noOfPages > pages) {
                count++;
                noOfPages = arr.get(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int n = arr.size();
        int m = 2;
        System.out.println(findPages(arr, n, m));
        // 113
    }
}
