package dp;

import java.util.HashMap;

public class SubarraysWithKDistinct {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return calSubarraysWithLessKDistinct(nums, k) - calSubarraysWithLessKDistinct(nums, k - 1);
    }

    private int calSubarraysWithLessKDistinct(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int i = 0, j = 0;
        int res = 0;
        for (; j < nums.length; j++) {
            if (hashMap.containsKey(nums[j])) {
                hashMap.put(nums[j], hashMap.get(nums[j]) + 1);
            } else {
                if (hashMap.size() < k) {
                    hashMap.put(nums[j], 1);
                } else {
                    while (hashMap.size() >= k) {
                        res += j - i;
                        hashMap.put(nums[i], hashMap.get(nums[i]) - 1);
                        if (hashMap.get(nums[i]) == 0) {
                            hashMap.remove(nums[i]);
                        }
                        i++;
                    }
                    hashMap.put(nums[j], hashMap.getOrDefault(hashMap.get(nums[j]), 0) + 1);
                }
            }
        }
        while (i < j && hashMap.size() > 0) {
            res += j - i;
            hashMap.put(nums[i], hashMap.get(nums[i]) - 1);
            if (hashMap.get(nums[i]) == 0) {
                hashMap.remove(nums[i]);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraysWithKDistinct subarraysWithKDistinct = new SubarraysWithKDistinct();
        int[] nums = {1,2,1,2,3};
        subarraysWithKDistinct.calSubarraysWithLessKDistinct(nums, 2);
    }
}
