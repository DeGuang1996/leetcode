package everyday;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class FindLongestWord {

    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((str1, str2) -> {
            if (str1.length() == str2.length()) {
                return str1.compareTo(str2);
            }
            return str2.length() - str1.length();
        });
        for (String word : dictionary) {
            if (isSubSeq(word, s)) {
                return word;
            }
        }
        return "";
    }

    private boolean isSubSeq(String word, String s) {
        if (word.length() > s.length()) {
            return false;
        }
        int i = 0, j = 0;
        for (; i < s.length() && j < word.length(); i++) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
        }
        return j >= word.length();
    }
}
