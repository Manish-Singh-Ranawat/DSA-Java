// Page Faults - https://www.naukri.com/code360/problems/page-faults_2826682

// In computing, a page fault is an exception for the memory management unit (MMU) when a process accesses a memory page without proper preparations.

// Page replacement algorithm is needed to decide which page needs to be replaced when the new page comes in. Whenever a new page is referred to and is not present in memory, the page fault occurs, and the Operating System replaces one of the existing pages with a newly needed page.

// You have given a sequence of pages in an array ‘Pages’ of length ‘N’ and memory capacity ‘C’. You have to find the number of page faults using the Least Recently Used (LRU) Algorithm. Initially, memory doesn't contain any pages.

// Input: c = 3 , pages =[1, 3, 2, 1]
// Output: 3
// Explanation: Memory allocated with three pages, {1, 3, 2}. 
// Hence total page faults = 3.
// Then, Page number '1' is required, which is already present. Hence total page faults = 3 + 0 = 3.

import java.util.Iterator;
import java.util.LinkedHashSet;

public class PageReplacementAlgorithm {
    public static int pageFaults(int C, int[] Pages) {
        int n = Pages.length;
        int faults = 0;
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(Pages[i])) {
                set.remove(Pages[i]);
                set.add(Pages[i]);
            } else {
                if (set.size() >= C) {
                    Iterator<Integer> it = set.iterator();
                    if (it.hasNext()) {
                        set.remove(it.next());
                    }
                }
                set.add(Pages[i]);
                faults++;
            }
        }
        return faults;
    }

    public static void main(String[] args) {
        int C = 3;
        int[] Pages = { 1, 3, 2, 1 };
        System.out.println(pageFaults(C, Pages));
        // 3
    }
}