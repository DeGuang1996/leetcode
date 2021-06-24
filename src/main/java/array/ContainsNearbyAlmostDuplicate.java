package array;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyAlmostDuplicate {

    private long getId(long num, long t) {
        if (num >= 0) {
            return num / (t + 1);
        } else {
            return ((num + 1) / (t + 1)) - 1;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // TreeSet<Long> treeSet = new TreeSet<>();
        // for (int i = 0; i < nums.length; i++) {
        //     if (treeSet.floor((long)nums[i]) != null) {
        //         long floor = treeSet.floor((long)nums[i]);
        //         if (Math.abs(floor - nums[i]) <= t) {
        //             return true;
        //         }
        //     }
        //     if (treeSet.ceiling((long)nums[i]) != null) {
        //         long ceiling = treeSet.ceiling((long)nums[i]);
        //         if (Math.abs(ceiling - nums[i]) <= t) {
        //             return true;
        //         }
        //     }
        //     treeSet.add((long)nums[i]);
        //     if (treeSet.size() > k) {
        //         treeSet.remove((long)nums[i - k]);
        //     }
        // }
        // return false;

        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], t);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1)) {
                long lower = map.get(id - 1);
                if (Math.abs(nums[i] - lower) <= t) {
                    return true;
                }
            }
            if (map.containsKey(id + 1)) {
                long upper = map.get(id + 1);
                if (Math.abs(nums[i] - upper) <= t) {
                    return true;
                }
            }
            map.put(id, (long)nums[i]);
            if (map.size() > k) {
                map.remove(getId(nums[i - k], t));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648,0};
        ContainsNearbyAlmostDuplicate containsNearbyAlmostDuplicate = new ContainsNearbyAlmostDuplicate();
        containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(nums, 1, 2147483647);
    }
}
