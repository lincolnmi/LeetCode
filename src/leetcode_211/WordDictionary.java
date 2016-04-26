package leetcode_211;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Problem definition:
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.
 */

/**
 * Answer:
 * Trie tree
 * when search come up with '.', we need to traverse all the child nodes.
 */

public class WordDictionary {
    private static final int R = 26;
    private Node root;

    private class Node {
        boolean isWord;
        Node[] next = new Node[R];
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        root = addWord(root,word,0);
    }

    private Node addWord(Node node, String word, int d) {
        if (node==null) {
            node = new Node();
        }
        if (d==word.length()) {
            node.isWord = true;
            return node;
        }
        char ch = word.charAt(d);
        node.next[ch-'a'] = addWord(node.next[ch-'a'],word,d+1);
        return node;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root,word,0);
    }

    private boolean search(Node node, String word, int d) {
        if (node==null) {
            return false;
        }
        if (d==word.length()) {
            return node.isWord;
        }
        char ch = word.charAt(d);
        if (ch=='.') {
            for (int i=0;i<R;i++) {
                boolean flag = search(node.next[i],word,d+1);
                if (flag) {
                    return true;
                }
            }
            return false;
        } else {
            return search(node.next[word.charAt(d) - 'a'], word, d + 1);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
