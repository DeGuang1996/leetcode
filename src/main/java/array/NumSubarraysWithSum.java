package array;

import java.util.HashMap;

public class NumSubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        count.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int left = sum - goal;
            if (count.containsKey(left)) {
                ans += count.get(left);
            }
            count.put(sum ,count.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,1};
        NumSubarraysWithSum numSubarraysWithSum = new NumSubarraysWithSum();
        numSubarraysWithSum.numSubarraysWithSum(nums, 2);
    }
}
