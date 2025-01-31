// Word Ladder II - https://www.geeksforgeeks.org/problems/word-ladder-ii/1

// Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find all shortest transformation sequence(s) from startWord to targetWord. You can return them in any order possible.

// Keep the following conditions in mind:
// A word can only consist of lowercase characters.
// Only one letter can be changed in each transformation.
// Each transformed word must exist in the wordList including the targetWord.
// startWord may or may not be part of the wordList.
// Return an empty list if there is no such transformation sequence.

// Input: startWord = "der", targetWord = "dfs", wordList = {"des","der","dfr","dgt","dfs"}
// Output: [[der, dfr, dfs], [der, des, dfs]]
// Explanation: The length of the smallest transformation is 3.
// And the following are the only two ways to get to targetWord:-
// "der" -> "dfr" -> "dfs".
// "der" -> "des" -> "dfs".

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder_II {
    public static ArrayList<ArrayList<String>> findSequences(String startWord,
            String targetWord,
            String[] wordList) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(targetWord))
            return ans;
        Queue<ArrayList<String>> q = new LinkedList<>();
        q.offer(new ArrayList<>(List.of(startWord)));
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;
        int len = startWord.length();
        while (!q.isEmpty()) {
            ArrayList<String> cur = q.poll();
            if (cur.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    set.remove(it);
                }
                usedOnLevel = new ArrayList<>();
            }
            String word = cur.get(cur.size() - 1);
            if (word.equals(targetWord)) {
                if (ans.size() == 0 || ans.get(0).size() == cur.size()) {
                    ans.add(new ArrayList<>(cur));
                }
            }
            for (int i = 0; i < len; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord)) {
                        cur.add(replacedWord);
                        q.offer(new ArrayList<>(cur));
                        usedOnLevel.add(replacedWord);
                        cur.remove(cur.size() - 1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String startWord = "der";
        String targetWord = "dfs";
        String[] wordList = { "des", "der", "dfr", "dgt", "dfs" };
        System.out.println(findSequences(startWord, targetWord, wordList));
        // [[der, dfr, dfs], [der, des, dfs]]
    }
}
