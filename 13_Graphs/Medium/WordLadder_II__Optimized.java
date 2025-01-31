// Word Ladder II - https://leetcode.com/problems/word-ladder-ii/

// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
// Explanation: There are 2 shortest transformation sequences:
// "hit" -> "hot" -> "dot" -> "dog" -> "cog"
// "hit" -> "hot" -> "lot" -> "log" -> "cog"

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder_II__Optimized {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(endWord))
            return ans;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        map.put(beginWord, 1);
        int len = beginWord.length();
        set.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = map.get(word);
            if (word.equals(endWord))
                break;
            for (int i = 0; i < len; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord)) {
                        q.offer(replacedWord);
                        set.remove(replacedWord);
                        map.put(replacedWord, steps + 1);
                    }
                }
            }
        }
        if (map.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, beginWord, map, seq, ans);
        }
        return ans;
    }

    public static void dfs(String word, String beginWord, HashMap<String, Integer> map, List<String> seq,
            List<List<String>> ans) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        int steps = map.get(word);
        int len = word.length();
        for (int i = 0; i < len; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                char[] replacedCharArray = word.toCharArray();
                replacedCharArray[i] = ch;
                String replacedWord = new String(replacedCharArray);
                if (map.containsKey(replacedWord) && map.get(replacedWord) + 1 == steps) {
                    seq.add(replacedWord);
                    dfs(replacedWord, beginWord, map, seq, ans);
                    seq.remove(replacedWord);
                }
            }
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(findLadders(beginWord, endWord, wordList));
        // [[hit, hot, dot, dog, cog], [hit, hot, lot, log, cog]]
    }

    // https://www.geeksforgeeks.org/problems/word-ladder-ii/1
    // public ArrayList<ArrayList<String>> findSequences(String startWord,
    // String targetWord,
    // String[] wordList) {
    // ArrayList<ArrayList<String>> ans = new ArrayList<>();
    // HashSet<String> set = new HashSet<>();
    // for (String s : wordList) {
    // set.add(s);
    // }
    // if (!set.contains(targetWord))
    // return ans;
    // Queue<ArrayList<String>> q = new LinkedList<>();
    // q.offer(new ArrayList<>(List.of(startWord)));
    // ArrayList<String> usedOnLevel = new ArrayList<>();
    // usedOnLevel.add(startWord);
    // int level = 0;
    // int len = startWord.length();
    // while (!q.isEmpty()) {
    // ArrayList<String> cur = q.poll();
    // if (cur.size() > level) {
    // level++;
    // for (String it : usedOnLevel) {
    // set.remove(it);
    // }
    // usedOnLevel = new ArrayList<>();
    // }
    // String word = cur.get(cur.size() - 1);
    // if (word.equals(targetWord)) {
    // if (ans.size() == 0 || ans.get(0).size() == cur.size()) {
    // ans.add(new ArrayList<>(cur));
    // }
    // }
    // for (int i = 0; i < len; i++) {
    // for (char ch = 'a'; ch <= 'z'; ch++) {
    // char[] replacedCharArray = word.toCharArray();
    // replacedCharArray[i] = ch;
    // String newWord = new String(replacedCharArray);
    // if (set.contains(newWord)) {
    // cur.add(newWord);
    // q.offer(new ArrayList<>(cur));
    // usedOnLevel.add(newWord);
    // cur.remove(cur.size() - 1);
    // }
    // }
    // }
    // }
    // return ans;
    // }

}
