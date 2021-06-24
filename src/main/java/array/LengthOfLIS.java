package array;

import java.util.Arrays;
import java.util.Comparator;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

        // int res = 0;
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // int len = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     int pre = len;
        //     while (len >= 0 && nums[i] <= dp[len]) {
        //         len--;
        //     }
        //     dp[len + 1] = nums[i];
        //     len = Math.max(len + 1, pre);
        //     res = Math.max(res, len + 1);
        // }
        // return res;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
        int res = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

        // Arrays.sort(envelopes, (o1, o2) -> {
        //     if (o1[0] != o2[0]) {
        //         return o1[0] - o2[0];
        //     } else {
        //         return o2[1] - o1[1];
        //     }
        // });
        // int res = 0;
        // int[] dp = new int[envelopes.length];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // int len = 0;
        // for (int i = 0; i < envelopes.length; i++) {
        //     int pre = len;
        //         while (len >= 0 && envelopes[i][1] <= dp[len]) {
        //             len--;
        //         }
        //         dp[len + 1] = envelopes[i][1];
        //         len = Math.max(len + 1, pre);
        //         res = Math.max(res, len + 1);
        // }
        // return res;
    }

    public int pileBox(int[][] box) {
        Arrays.sort(box, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        int[] dp = new int[box.length];
        for (int i = 0; i < box.length; i++) {
            dp[i] = box[i][2];
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
