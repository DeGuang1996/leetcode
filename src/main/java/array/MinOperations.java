package array;

import java.util.ArrayList;
import java.util.HashMap;

public class MinOperations {

    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            hashMap.put(target[i], i);
        }
        ArrayList<Integer> nums = new ArrayList<>();
        for (int num : arr) {
            if (hashMap.containsKey(num)) {
                nums.add(hashMap.get(num));
            }
        }
        ArrayList<Integer> lis = new ArrayList<>(target.length);
        for (int i = 0; i < nums.size(); i++) {
            if (lis.isEmpty()) {
                lis.add(nums.get(i));
                continue;
            }
            int idx = binarySearch(lis, 0, lis.size(), nums.get(i));
            if (idx >= lis.size()) {
                lis.add(nums.get(i));
            } else {
                lis.set(idx, nums.get(i));
            }
        }
        return target.length - lis.size();
    }

    private int binarySearch(ArrayList<Integer> nums, int begin, int end, int target) {
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums.get(mid) < target) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        int[] target = {17,18,14,13,6,9,1,3,2,20};
        int[] arr = {18,15,14,6,6,13,15,20,2,6};
        minOperations.minOperations(target, arr);
    }
}
