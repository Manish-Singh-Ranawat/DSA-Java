// Complete String - https://www.naukri.com/code360/problems/complete-string_2687860?

// Ninja developed a love for arrays and strings so this time his teacher gave him an array of strings, ‘A’ of size ‘N’. Each element of this array is a string. The teacher taught Ninja about prefixes in the past, so he wants to test his knowledge.

// A string is called a complete string if every prefix of this string is also present in the array ‘A’. Ninja is challenged to find the longest complete string in the array ‘A’.If there are multiple strings with the same length, return the lexicographically smallest one and if no string exists, return "None".

// Note :
// String ‘P’ is lexicographically smaller than string ‘Q’, if : 

// 1. There exists some index ‘i’ such that for all ‘j’ < ‘i’ , ‘P[j] = Q[j]’ and ‘P[i] < Q[i]’. E.g. “ninja” < “noder”.
// 2. If ‘P’ is a prefix of string ‘Q’, e.g. “code” < “coder”.

// Input : n = 6, a = [ n, ni, nin, ninj, ninja, ninga]
// Output : ninja
// Explanation : All the prefixes of “ninja” -> “n”, “ni”, “nin”, “ninj” and “ninja” are present in array ‘A’. So, “ninja” is a valid answer whereas for “ninga” , the prefix “ning” is not present in array ‘A’.
// So we output “ninja”.

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

class Trie {
    public Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public static boolean checkIfPrefixExists(String s, Trie trie) {
        Node node = trie.root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
                if (!node.isEnd())
                    return false;
            } else
                return false;
        }
        return true;
    }
}

public class CompleteString {
    public static String completeString(int n, String[] a) {
        Trie trie = new Trie();
        for (String s : a) {
            trie.insert(s);
        }
        String ans = "";
        for (String s : a) {
            if (trie.checkIfPrefixExists(s, trie)) {
                if (s.length() > ans.length() || s.length() == ans.length() && s.compareTo(ans) < 0) {
                    ans = s;
                }
            }
        }
        return ans.length() == 0 ? "None" : ans;
    }

    public static void main(String[] args) {
        String[] a = { "n", "ni", "nin", "ninj", "ninja", "ninga" };
        int n = a.length;
        System.out.println(completeString(n, a));
        // ninja
    }
}
