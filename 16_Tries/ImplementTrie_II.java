// Implement Trie II - https://www.naukri.com/code360/problems/implement-trie_1387095?

// Ninja has to implement a data structure ”TRIE” from scratch. Ninja has to complete some functions.

// 1) Trie(): Ninja has to initialize the object of this “TRIE” data structure.

// 2) insert(“WORD”): Ninja has to insert the string “WORD”  into this “TRIE” data structure.

// 3) countWordsEqualTo(“WORD”): Ninja has to return how many times this “WORD” is present in this “TRIE”.

// 4) countWordsStartingWith(“PREFIX”): Ninjas have to return how many words are there in this “TRIE” that have the string “PREFIX” as a prefix.

// 5) erase(“WORD”): Ninja has to delete one occurrence of the string “WORD” from the “TRIE”.

// Note : If erase(“WORD”) function is called then it is guaranteed that the “WORD” is present in the “TRIE”.

// Input :
// insert samsung
// insert samsung
// insert vivo
// erase vivo
// countWordsEqualTo samsung
// countWordsStartingWith vi

// Output : 2 , 0

// Explanation :
// insert “samsung”: we are going to insert the word “samsung” into the “TRIE”.
// insert “samsung”: we are going to insert another “samsung” word into the “TRIE”.
// insert “vivo”: we are going to insert the word “vivo” into the “TRIE”.
// erase “vivo”: we are going to delete the word “vivo” from the “TRIE”.
// countWordsEqualTo “samsung”: There are two instances of “samsung” is present in “TRIE”.
// countWordsStartingWith “vi”: There is not a single word in the “TRIE” that starts from the prefix “vi”.

class Node {
    Node[] links;
    int countEndsWith;
    int countPrefix;

    Node() {
        this.links = new Node[26];
        this.countEndsWith = 0;
        this.countPrefix = 0;
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

    public void increasePrefix() {
        countPrefix++;
    }

    public void decreasePrefix() {
        countPrefix--;
    }

    public void increaseEndWith() {
        countEndsWith++;
    }

    public void decreaseEndWith() {
        countEndsWith--;
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
            node.increasePrefix();
        }
        node.increaseEndWith();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else
                return 0;
        }
        return node.countEndsWith;
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else
                return 0;
        }
        return node.countPrefix;
    }

    public void erase(String word) {
        Node node = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            node = node.get(ch);
            node.decreasePrefix();
        }
        node.decreaseEndWith();
    }
}

public class ImplementTrie_II {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("samsung");
        trie.insert("samsung");
        trie.insert("vivo");
        trie.erase("vivo");
        System.out.println(trie.countWordsEqualTo("samsung")); // 2
        System.out.println(trie.countWordsStartingWith("vi")); // 0
    }
}
