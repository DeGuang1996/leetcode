package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    // public int[] twoSum(int[] nums, int target) {
    //     HashMap<Integer, List<Integer>> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (map.containsKey(nums[i])) {
    //             List<Integer> list = map.get(nums[i]);
    //             list.add(i);
    //         } else {
    //             List<Integer> list = new ArrayList<>();
    //             list.add(i);
    //             map.put(nums[i], list);
    //         }
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         int dis = target - nums[i];
    //         if (dis != nums[i] && map.containsKey(dis)) {
    //             return new int[]{i, map.get(dis).get(0)};
    //         }
    //         if (dis == nums[i] && map.get(dis).size() > 1) {
    //             return new int[]{i, map.get(dis).get(1)};
    //         }
    //     }
    //     return null;
    // }

    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            while (i < j && numbers[i] + numbers[j] > target) {
                j--;
            }
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i, j};
            }
        }
        return null;
    }

}
