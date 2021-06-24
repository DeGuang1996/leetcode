package dp;

public class CountSubSequence {

    public int countSubSequence(String word, int n) {
        int[][] dp = new int[word.length() + 1][word.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        return dp[word.length()][n];
    }

    public static void main(String[] args) {
        CountSubSequence countSubSequence = new CountSubSequence();
        countSubSequence.countSubSequence("aabaa", 1);
    }
}
