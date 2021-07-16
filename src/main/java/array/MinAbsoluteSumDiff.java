package array;

import java.util.Arrays;
import java.util.TreeSet;

public class MinAbsoluteSumDiff {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums1) {
            treeSet.add(num);
        }
        int MOD = (int) 1e9 + 7;
        int maxDis = 0;
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            Integer floor = treeSet.floor(nums2[i]);
            floor = (floor == null ? treeSet.first() : floor);
            Integer ceil = treeSet.ceiling(nums2[i]);
            ceil = (ceil == null ? treeSet.last() : ceil);
            int minDis = Math.min(Math.abs(floor - nums2[i]), Math.abs(ceil - nums2[i]));
            int curDis = Math.abs(nums1[i] - nums2[i]);
            maxDis = Math.max(maxDis, curDis - minDis);
            ans += curDis;
            ans %= MOD;
        }
        return (ans + MOD - maxDis) % MOD;
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans = 1;
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
            ans = arr[i];
        }
        return ans;
    }
}
