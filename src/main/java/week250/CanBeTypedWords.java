package week250;

public class CanBeTypedWords {

    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        int i = 0;
        for (; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                ans++;
            }
            if (brokenLetters.contains(text.substring(i, i + 1))) {
                i = text.indexOf(" ", i);
                if (i == -1) {
                    break;
                }
            }
        }
        if (i != -1) {
            ans++;
        }
        return ans;
    }
}
