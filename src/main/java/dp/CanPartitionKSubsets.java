package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            list.add(num);
        }
        list.sort((o1, o2) -> o2 - o1);
        if (sum % k != 0 || list.get(0) > sum / k) {
            return false;
        }
        int[] part = new int[k];
        return dfs(list, 0, k, sum / k, part);
    }

    private boolean dfs(List<Integer> list, int begin, int k, int target, int[] part) {
        if (begin == list.size()) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (part[i] + list.get(begin) <= target) {
                part[i] += list.get(begin);
                if (dfs(list, begin + 1, k, target, part)) {
                    return true;
                } else {
                    part[i] -= list.get(begin);
                    if (part[i] == 0) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanPartitionKSubsets canPartitionKSubsets = new CanPartitionKSubsets();
        int[] nums = {2,2,2,2,3,4,5};
        canPartitionKSubsets.canPartitionKSubsets(nums, 4);
    }
}
