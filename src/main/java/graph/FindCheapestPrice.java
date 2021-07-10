package graph;

import java.util.Arrays;

public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[n][K + 1];
        for (int[] num : dp) {
            Arrays.fill(num, Integer.MAX_VALUE);
        }
        Arrays.fill(dp[src], 0);
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            if (from == src) {
                dp[to][0] = dp[from][0] + cost;
            }
        }
        for (int i = 1; i <= K; i++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                if (dp[from][i - 1] != Integer.MAX_VALUE) {
                    dp[to][i] = Math.min(dp[from][i - 1] + cost, dp[to][i]);
                }
            }
        }
        if (dp[dst][K] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[dst][K];
    }
}
