// K Max Sum Combinations - https://www.naukri.com/code360/problems/k-max-sum-combinations_975322?leftPanelTabValue=PROBLEM

// You are given two arrays/lists ‘A’ and ‘B’ of size ‘N’ each. You are also given an integer ‘K’. You must return ‘K’ distinct maximum and valid sum combinations from all the possible sum combinations of the arrays/lists ‘A’ and ‘B’.

// Sum combination adds one element from array ‘A’ and another from array ‘B’.

// Input : a = [1, 3, 5], b = [6, 4, 2], n = 3, k = 2
// Output : [11, 9]
// Explanation  : For the given arrays/lists, all the possible sum combinations are: 
// 7(1 + 6), 5(1 + 4), 3(1 + 2), 9(3 + 6), 7(3 + 4), 5(3 + 2), 11(6 + 5), 9(5 + 4), 7(5 + 2).

// The two maximum sum combinations from the above combinations are 11 and 9. 

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class KMaxSumCombinations {
    public static int[] kMaxSumCombination(int[] a, int[] b, int n, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> maxHeap = new PriorityQueue<>((x,y) -> y.getKey() - x.getKey());
        maxHeap.add(new Pair<>(a[n - 1] + b[n - 1], new Pair<>(n - 1, n - 1)));
        Set<Pair<Integer, Integer>> mySet = new HashSet<>();
        mySet.add(new Pair<>(n - 1, n - 1));
        int[] result = new int[k];
        int index = 0;
        while (k > 0) {
            Pair<Integer, Pair<Integer, Integer>> top = maxHeap.poll();
            int sum = top.getKey();
            int x = top.getValue().getKey();
            int y = top.getValue().getValue();
            result[index++] = sum;
            if (x - 1 >= 0 && !mySet.contains(new Pair<>(x - 1, y))) {
                maxHeap.add(new Pair<>(a[x - 1] + b[y], new Pair<>(x - 1, y)));
                mySet.add(new Pair<>(x - 1, y));
            }
            if (y - 1 >= 0 && !mySet.contains(new Pair<>(x, y - 1))) {
                maxHeap.add(new Pair<>(a[x] + b[y - 1], new Pair<>(x, y - 1)));
                mySet.add(new Pair<>(x, y - 1));
            }
            k -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 5 };
        int[] b = { 6, 4, 2 };
        int n = 3, k = 2;
        System.out.println(Arrays.toString(kMaxSumCombination(a, b, n, k)));
        // [11, 9]
    }
}

class Pair<F, S> {
    public F first;
    public S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getKey() {
        return first;
    }

    public S getValue() {
        return second;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Pair))
            return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}