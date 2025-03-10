// Sort Characters By Frequency - https://leetcode.com/problems/sort-characters-by-frequency/description/

// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

// Return the sorted string. If there are multiple answers, return any of them.

// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }
        StringBuilder ans = new StringBuilder();
        while (true) {
            int max = 0;
            int idx = -1;
            for (int i = 0; i < 128; i++) {
                if (count[i] > max) {
                    max = count[i];
                    idx = i;
                }
            }
            if (idx == -1)
                break;
            for (int i = 0; i < max; i++) {
                ans.append((char) (idx));
            }
            count[idx] = 0;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
        // eert
    }
}
