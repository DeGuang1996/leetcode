package array;

public class NumberOfSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + (nums[i] % 2);
        }
        int[] count = new int[preSum.length];
        for (int i = 0; i < preSum.length; i++) {
            count[preSum[i]]++;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum[i + 1] - k >= 0) {
                res += count[preSum[i + 1] - k];
            }
        }
        return res;
    }
}
