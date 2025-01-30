// Alien dictionary - https://www.naukri.com/code360/problems/alien-dictionary_630423?leftPanelTabValue=PROBLEM

// You have been given a sorted (lexical order) dictionary of an alien language.

// Write a function that returns the order of characters as a string in the alien language. This dictionary will be given to you as an array of strings called 'dictionary', of size 'N'.

// Note: If the language consists of four letters, the four letters should be the starting four letters of the English language.  However, their order might differ in the alien language.

// If the dictionary consists of the following words:-

// Input : dictionary = ["caa", "aaa", "aab"], K = 3
// Output : ['c', 'a', 'b']

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public static String getAlienLanguage(String[] dictionary, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        int n = dictionary.length;
        for (int i = 0; i < n - 1; i++) {
            String s1 = dictionary[i];
            String s2 = dictionary[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        ArrayList<Integer> list = topologicalSort(adj, k);
        StringBuilder res = new StringBuilder();
        for (int it : list) {
            res.append((char) (it + (int) 'a') + " ");
        }
        return res.toString();
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int v) {
        int[] inDeg = new int[v];
        for (int i = 0; i < v; i++) {
            for (int adjNode : adj.get(i)) {
                inDeg[adjNode]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            list.add(cur);
            for (int adjNode : adj.get(cur)) {
                inDeg[adjNode]--;
                if (inDeg[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] dictionary = { "caa", "aaa", "aab" };
        int K = 3;
        System.out.println(getAlienLanguage(dictionary, K));
        // c a b
    }
}
