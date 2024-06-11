package everyday;

import java.time.LocalDateTime;
import java.util.*;

public class FindPeakElement {

    public int findPeakElement(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int lmid = (right - left) / 2 + left;
            int rmid = lmid + 1;
            if (nums[lmid] <= nums[rmid]) {
                left = lmid + 1;
            } else {
                right = rmid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }
}
