package dp;

public class MinJump {

    public int minJump(int[] jump) {
        int[] dp = new int[jump.length];
        dp[jump.length - 1] = 1;
        for (int i = jump.length - 2; i >= 0; i--) {
            dp[i] = i + jump[i] >= jump.length ? 1 : dp[i + jump[i]] + 1;
            for (int j = i + 1; j < Math.min(i + jump[i], dp.length) && dp[j] >= dp[i] + 1; j++) {
                dp[j] = dp[i] + 1;
            }
        }
        return dp[0];
    }
}
