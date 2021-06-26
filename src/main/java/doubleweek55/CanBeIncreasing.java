package doubleweek55;

import java.util.Arrays;

public class CanBeIncreasing {
    public boolean canBeIncreasing(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int[] cur = new int[nums.length - 1];
            for (int j = 0, count = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                cur[count++] = nums[j];
            }

            int j = 0;
            for (; j < cur.length; j++) {
                if (j > 0 && cur[j] <= cur[j - 1]) {
                    break;
                }
            }
            if (j == cur.length) {
                return true;
            }
        }
        return false;
    }
}
