package dp;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        // int pre = 0, res = nums[0];
        // for (int num : nums) {
        //     pre = Math.max(pre + num, num);
        //     res = Math.max(res, pre);
        // }
        // return res;

        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int[] preSumMin = new int[nums.length + 1];
        for (int i = 1; i < preSumMin.length; i++) {
            preSumMin[i] = Math.min(preSumMin[i - 1], preSum[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < preSum.length; i++) {
            res = Math.max(res, preSum[i] - preSumMin[i - 1]);
        }
        return res;
    }
}
