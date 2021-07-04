package dp;

import java.util.Arrays;

public class MaxProfit {

    public int maxProfit1(int[] prices) {
        int buy = -prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        return ans;
    }

    public int maxProfit2(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    public int maxProfit3(int[] prices) {
        int[][] dp = new int[2][2];
        dp[0][0] = dp[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0][0] = Math.max(dp[0][0], -prices[i]);
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + prices[i]);
            dp[1][0] = Math.max(dp[1][0], dp[0][1] - prices[i]);
            dp[1][1] = Math.max(dp[1][1], dp[1][0] + prices[i]);
        }
        return dp[1][1];
    }

    public int maxProfit4(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        int[][] dp = new int[k][2];
        for (int i = 0; i < k; i++) {
            dp[i][0] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            int pre = 0;
            for (int j = 0; j < k; j++) {
                dp[j][0] = Math.max(dp[j][0], pre - prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
                pre = dp[j][1];
            }
        }
        return dp[k - 1][1];
    }

    public int maxProfitWithCoolDown(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        for (int[] temp : dp) {
            Arrays.fill(temp, 0);
        }
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    public int maxProfitWithFee(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }

}
