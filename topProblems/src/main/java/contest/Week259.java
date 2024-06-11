package contest;

import java.util.PriorityQueue;

public class Week259 {

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            if (operation.contains("++")) {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }

    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        int curr = nums[0];
        for (int i = 1; i < n - 1; i++) {
            leftMax[i] = curr;
            curr = Math.max(curr, nums[i]);
        }
        curr = nums[n - 1];
        for (int i = n - 1; i >= 1; i--) {
            rightMin[i] = curr;
            curr = Math.min(curr, nums[i]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (leftMax[i] < nums[i] && nums[i] < rightMin[i]) {
                ans += 2;
            }
            else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
}
