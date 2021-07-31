package array;

import java.util.Arrays;

public class MinPairSum {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            ans = Math.max(ans, nums[i] + nums[j]);
            i++;
            j--;
        }
        return ans;
    }
}
