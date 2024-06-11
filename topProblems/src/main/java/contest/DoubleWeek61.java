package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DoubleWeek61 {

    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[]{};
        }
        long sum = 0;
        Arrays.sort(changed);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : changed) {
            sum += num;
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        if (sum % 3 != 0) {
            return new int[]{};
        }
        int[] ans = new int[changed.length / 2];
        int idx = 0;
        for (int num : changed) {
            if (hashMap.containsKey(num * 2) && hashMap.containsKey(num)) {
                if (num * 2 == num) {
                    if (!(hashMap.get(num) % 2 == 0)) {
                        return new int[]{};
                    }
                }
                ans[idx++] = num;
                if (idx >= changed.length / 2) {
                    break;
                }
                hashMap.put(num * 2, hashMap.get(num * 2) - 1);
                if (hashMap.get(num * 2) == 0) {
                    hashMap.remove(num * 2);
                }
                hashMap.put(num, hashMap.get(num) - 1);
                if (hashMap.get(num) == 0) {
                    hashMap.remove(num);
                }
            }
        }
        if (idx >= changed.length / 2) {
            return ans;
        }
        return new int[]{};
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] ans = new long[n + 1];
        Arrays.sort(rides, (ride1, ride2) -> ride1[1] - ride2[1]);
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            while (i >= rides[idx][1]) {
                ans[i] = Math.max(ans[i], ans[rides[idx][0]] + rides[idx][1] - rides[idx][0] + rides[idx][2]);
                if (idx == rides.length - 1) {
                    break;
                }
                if (idx < rides.length - 1) {
                    idx++;
                }
            }
            ans[i] = Math.max(ans[i - 1], ans[i]);
        }
        return ans[n];
    }

    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                arrayList.add(nums[i]);
            }
        }

        int ans = nums.length;
        for (int i = 0; i < arrayList.size(); i++) {
            int max = arrayList.get(i) + nums.length - 1;
            int maxIdx = upperBound(arrayList, max);
            int maxCount = nums.length - (maxIdx - i);
            ans = Math.min(ans, maxCount);
        }
        return ans;
    }

    private int upperBound(ArrayList<Integer> nums, int tar) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) <= tar) {
                left = mid + 1;
            }
            else if (nums.get(mid) > tar) {
                right = mid;
            }
        }
        if (nums.get(left) <= tar) {
            return left + 1;
        }
        return left;
    }
}
