package week248;

import java.util.HashSet;

public class LongestCommonSubpath {

    public int longestCommonSubpath(int n, int[][] paths) {
        // String[] strings = new String[n];
        // for (int i = 0; i < paths.length; i++) {
        //     StringBuilder temp = new StringBuilder();
        //     for (int j = 0; j < paths[i].length; j++) {
        //         temp.append(paths[i][j]);
        //         if (j != paths[i].length - 1) {
        //             temp.append(',');
        //         }
        //     }
        //     strings[i] = temp.toString();
        // }
        return 0;
    }

    public int[] findErrorNums(int[] nums) {
        int curSum = 0;
        int duplicate = nums[0];
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (hashSet.contains(nums[i])) {
                duplicate = nums[i];
            }
            hashSet.add(nums[i]);
        }
        int sum = (nums.length * (nums.length + 1)) / 2;
        return new int[]{duplicate, duplicate + sum - curSum};
    }
}
