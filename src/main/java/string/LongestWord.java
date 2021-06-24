package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWord {

    public String longestWord(String[] words) {
        String res = "";
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (word.length() > res.length() || (word.length() == res.length() && res.compareTo(word) > 0)) {
                int i = 0;
                for (; i < word.length(); i++) {
                    if (!set.contains(word.substring(0, i + 1))) {
                        break;
                    }
                }
                if (i == word.length()) {
                    res = word;
                }
            }
        }
        return res;
    }
}
