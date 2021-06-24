package dp;

import binarytree.TreeNode;

import java.util.Arrays;

public class Rob {

    public int rob1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 0);
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public int rob2(int[] nums) {
        int[] numsWithStart = new int[nums.length - 1];
        int[] numsWithEnd = new int[nums.length - 1];
        System.arraycopy(nums, 0, numsWithStart, 0, numsWithStart.length);
        System.arraycopy(nums, 1, numsWithEnd, 0, numsWithEnd.length);

        return Math.max(rob1(numsWithStart), rob1(numsWithEnd));
    }

    public int rob3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int grandSonSum = 0;
        int childSum = 0;
        if (root.left != null) {
            grandSonSum += rob3(root.left.left) + rob3(root.left.right);
        }
        if (root.right != null) {
            grandSonSum += rob3(root.right.left) + rob3(root.right.right);
        }
        childSum += rob3(root.left) + rob3(root.right);
        return Math.max(childSum, root.val + grandSonSum);
    }

    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}
