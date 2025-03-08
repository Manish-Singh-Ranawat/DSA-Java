// Reverse Words in a String - https://leetcode.com/problems/reverse-words-in-a-string/

// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int i = n - 1;
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                temp = temp.append(s.charAt(i));
            } else {
                if (temp.length() > 0)
                    ans.append(temp.reverse() + " ");
                temp = new StringBuilder();
            }
            i--;
        }
        if (temp.length() > 0)
            ans.append(temp.reverse() + " ");
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
        // world hello
    }
}
