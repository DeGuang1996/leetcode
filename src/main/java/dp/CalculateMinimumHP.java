package dp;

import java.util.Arrays;

public class CalculateMinimumHP {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        for (int[] temp : dp) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 >= m && j + 1 >= n) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i + 1 < m && j + 1 >= n) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else if (i + 1 >= m && j + 1 < n) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] - dungeon[i][j], dp[i][j + 1] - dungeon[i][j]);
                    dp[i][j] = Math.max(dp[i][j], 1);
                }
            }
        }
        return dp[0][0];
    }
}
