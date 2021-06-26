package dp;

import java.util.Arrays;

public class Jump {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int end = i + nums[i];
            if (end >= nums.length - 1) {
                return dp[i] + 1;
            }
            for (int j = end; j > i; j--) {
                if (dp[j] <= dp[i] + 1) {
                    break;
                }
                dp[j] = dp[i] + 1;
            }
        }
        return 0;
    }
}
