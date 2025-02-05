package dp;

import java.util.Arrays;

public class IsMatch {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (boolean[] booleans : dp) {
            Arrays.fill(booleans, false);
        }
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            dp[i][0] = (p.charAt(i - 1) == '*' && dp[i - 2][0]);
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]) || dp[i][j - 2] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        isMatch.isMatch("mississippi", "mis*is*p*.");
    }
}
