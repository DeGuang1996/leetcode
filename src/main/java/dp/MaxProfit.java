package dp;

import java.util.Arrays;

public class MaxProfit {

    public int maxProfit(int[] prices, int fee) {
        // int global = 0;
        // int local = 0;
        // for (int i = 1; i < prices.length; i++) {
        //     int diff = prices[i] - prices[i - 1];
        //     local = Math.max(global, local) + diff;
        //     global = Math.max(global, local - fee);
        // }
        // return global;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        for (int[] temp : dp) {
            Arrays.fill(temp, 0);
        }
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][2] - prices[i];
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1] + prices[i] - prices[i - 1]);
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
