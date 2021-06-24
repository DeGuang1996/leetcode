package datastructure;

class Trie {

    Trie[] next;
    boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curTrie = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curTrie.next[idx] == null) {
                curTrie.next[idx] = new Trie();
            }
            curTrie = curTrie.next[idx];
        }
        curTrie.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie result = searchPreFix(word);
        return result != null && result.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPreFix(prefix) != null;
    }

    public Trie searchPreFix(String word) {
        Trie curTrie = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curTrie.next[idx] == null) {
                return null;
            }
            curTrie = curTrie.next[idx];
        }
        return curTrie;
    }
}
