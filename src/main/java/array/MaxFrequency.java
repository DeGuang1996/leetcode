package array;

import java.util.Arrays;

public class MaxFrequency {

    public int maxFrequency(int[] nums, int k) {
        // Arrays.sort(nums);
        // int left = 0, ans = 1;
        // long total = 0;
        // for (int right = 1; right < nums.length; right++) {
        //     total += (long) (nums[right] - nums[right - 1]) * (right - left);
        //     while (total > k) {
        //         total -= nums[right] - nums[left];
        //         left++;
        //     }
        //     ans = Math.max(ans, right - left + 1);
        // }
        // return ans;

        Arrays.sort(nums);
        long[] pre = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        int left = 1, right = nums.length;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (isValid(nums, pre, k ,mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean isValid(int[] nums, long[] pre, int k, int length) {
        for (int i = nums.length; i >= length; i--) {
            if (pre[i] - pre[i - length] + k >= (long) nums[i - 1] * length) {
                return true;
            }
        }
        return false;
    }
}
