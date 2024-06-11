package contest;

import java.util.HashMap;

public class DoubleWeek62 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            ans[i / n][i % n] = original[i];
        }
        return ans;
    }

    public int numOfPairs(String[] nums, String target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                String temp = nums[i] + nums[j];
                if (temp.equals(target)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ans = 0;
        int count = k;
        int left = 0, right = 0, n = answerKey.length();
        while (right < n) {
            if (answerKey.charAt(right) == 'T') {
                right++;
            } else if (count > 0) {
                count--;
                right++;
            } else {
                ans = Math.max(ans, right - left);
                while (left < right && answerKey.charAt(left) == 'T') {
                    left++;
                }
                left++;
                right++;
            }
        }
        ans = Math.max(ans, right - left);
        count = k;
        left = 0;
        right = 0;
        while (right < n) {
            if (answerKey.charAt(right) == 'F') {
                right++;
            } else if (count > 0) {
                count--;
                right++;
            } else {
                ans = Math.max(ans, right - left);
                while (left < right && answerKey.charAt(left) == 'F') {
                    left++;
                }
                left++;
                right++;
            }
        }
        ans = Math.max(ans, right - left);
        return ans;
    }

    public int waysToPartition(int[] nums, int k) {
        int ans = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        HashMap<Long, Integer> sumMap = new HashMap<>();
        long preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (i != nums.length - 1) {
                sumMap.put(preSum, sumMap.getOrDefault(preSum, 0) + 1);
            }
        }
        if (sum % 2 == 0) {
            ans = Math.max(ans, sumMap.getOrDefault(sum / 2, 0));
        }
        HashMap<Long, Integer> preMap = new HashMap<>();
        preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int dis = k - nums[i];
            if ((sum + dis) % 2 == 0) {
                ans = Math.max(ans, sumMap.getOrDefault((sum - dis) / 2, 0) + preMap.getOrDefault((sum + dis) / 2, 0));
            }
            preSum += nums[i];
            sumMap.put(preSum, sumMap.getOrDefault(preSum, 0) - 1);
            preMap.put(preSum, preMap.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
