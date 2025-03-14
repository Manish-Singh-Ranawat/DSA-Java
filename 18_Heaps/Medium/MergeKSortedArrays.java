// Merge K Sorted Arrays - https://www.naukri.com/code360/problems/merge-k-sorted-arrays_975379?leftPanelTabValue=PROBLEM

// You have been given ‘K’ different arrays/lists, which are sorted individually (in ascending order). You need to merge all the given arrays/list such that the output array/list should be sorted in ascending order.

// Input : k = 2, kArrays = [[3, 5, 9], [1, 2, 3, 8]]
// Output : [1, 2, 3, 3, 5, 8, 9] 
// Explanation : After merging the two given arrays/lists [3, 5, 9] and [ 1, 2, 3, 8], the output sorted array will be [1, 2, 3, 3, 5, 8, 9].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.num - b.num);
        for (int i = 0; i < k; i++) {
            int first = kArrays.get(i).get(0);
            pq.offer(new Pair(first, i, 0));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ans.add(p.num);
            ArrayList<Integer> curArr = kArrays.get(p.arr);
            int nextIdx = p.idx + 1;
            if (nextIdx < curArr.size()) {
                int num = curArr.get(nextIdx);
                pq.offer(new Pair(num, p.arr, nextIdx));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> kArrays = new ArrayList<>();
        kArrays.add(new ArrayList<>(Arrays.asList(3, 5, 9)));
        kArrays.add(new ArrayList<>(Arrays.asList(1, 2, 3, 8)));
        int k = 2;
        System.out.println(mergeKSortedArrays(kArrays, k));
        // [1, 2, 3, 3, 5, 8, 9]
    }
}

class Pair {
    int num;
    int arr;
    int idx;

    Pair(int num, int arr, int idx) {
        this.num = num;
        this.arr = arr;
        this.idx = idx;
    }
}