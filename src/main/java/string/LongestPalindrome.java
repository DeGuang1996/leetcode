package string;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i < s.length() - 1) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }
        for (int len = 2; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                if (s.charAt(i) == s.charAt(i + len) && dp[i + 1][i + len - 1]) {
                    dp[i][i + len] = true;
                }
            }
        }
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
