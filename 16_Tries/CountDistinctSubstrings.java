// Count Distinct Substrings - https://www.naukri.com/code360/problems/count-distinct-substrings_985292?

// Given a string 'S', you are supposed to return the number of distinct substrings(including empty substring) of the given string. You should implement the program using a trie.

// Note :
// A string ‘B’ is a substring of a string ‘A’ if ‘B’ that can be obtained by deletion of, several characters(possibly none) from the start of ‘A’ and several characters(possibly none) from the end of ‘A’. 

// Two strings ‘X’ and ‘Y’ are considered different if there is at least one index ‘i’  such that the character of ‘X’ at index ‘i’ is different from the character of ‘Y’ at index ‘i’(X[i]!=Y[i]).

// Input : s  = "abab"
// Output : 8
// Explanation : The eight distinct substrings are {‘a’, ‘b’, “ab”, “ba”, “aba”, “bab”, “abab”, “” }

class Node {
    Node[] links;
    boolean flag;

    Node() {
        this.links = new Node[26];
        this.flag = false;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

public class CountDistinctSubstrings {
    public static int countDistinctSubstrings(String s) {
        Node root = new Node();
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Node node = root;
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (!node.containsKey(ch)) {
                    ans++;
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(countDistinctSubstrings(s));
        // 8
    }
}

