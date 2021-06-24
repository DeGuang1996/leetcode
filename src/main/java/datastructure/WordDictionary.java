package datastructure;

public class WordDictionary {

    WordDictionary[] next;
    boolean isEnd;

    /** Initialize your data structure here. */
    public WordDictionary() {
        next = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary wordDictionary = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (wordDictionary.next[idx] == null) {
                wordDictionary.next[idx] = new WordDictionary();
            }
            wordDictionary = wordDictionary.next[idx];
        }
        wordDictionary.isEnd = true;
    }

    public boolean search(String word) {
        return searchPreFix(this, word);
    }

    public boolean searchPreFix(WordDictionary wordDictionary, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < wordDictionary.next.length; j++) {
                    if (wordDictionary.next[j] != null && searchPreFix(wordDictionary.next[j], word.substring(i + 1))) {
                        return true;
                    }
                }
            }
            int idx = word.charAt(i) - 'a';
            if (wordDictionary.next[idx] == null) {
                return false;
            }
            wordDictionary = wordDictionary.next[idx];
        }
        return wordDictionary.isEnd;
    }
}
