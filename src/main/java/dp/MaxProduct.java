package dp;

import java.util.Arrays;

public class MaxProduct {

    public int maxProduct(int[] nums) {
        // int[] max = new int[nums.length];
        // int[] min = new int[nums.length];
        // System.arraycopy(nums, 0, max, 0, nums.length);
        // System.arraycopy(nums, 0, min, 0, nums.length);
        //
        // for (int i = 1; i < nums.length; i++) {
        //     max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
        //     min[i] = Math.min(max[i - 1] * nums[i], Math.min(nums[i], min[i - 1] * nums[i]));
        // }
        // int res = nums[0];
        // for (int i = 1; i < max.length; i++) {
        //     res = Math.max(res, max[i]);
        // }
        // return res;

        int max = nums[0], min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMax = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            int curMin = Math.min(max * nums[i], Math.min(nums[i], min * nums[i]));
            res = Math.max(res, curMax);
            max = curMax;
            min = curMin;
        }
        return res;
    }
}
