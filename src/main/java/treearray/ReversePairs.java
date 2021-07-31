package treearray;

import java.util.*;

public class ReversePairs {

    private int ans = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        calculate(nums, left, mid, right);
        merge(nums, left, mid, right);
    }

    private void calculate(int[] nums, int left, int mid, int right) {
        for (int i = left, j = mid; i <= mid; i++) {
            while (j < right && nums[i] > nums[j + 1]) {
                j++;
            }
            ans += j - mid;
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        for (int k = 0; k < temp.length; k++) {
            if (j > right || (i <= mid && nums[i] <= nums[j])) {
                temp[k] = nums[i++];
            } else {
                temp[k] = nums[j++];
            }
        }
        for (int k = 0; k < temp.length; k++) {
            nums[k + left] = temp[k];
        }
    }

    // public int reversePairs(int[] nums) {
    //     // int[] copy = Arrays.copyOf(nums, nums.length);
    //     // Arrays.sort(copy);
    //     //
    //     // int[] treeArray = new int[nums.length + 1];
    //     // Arrays.fill(treeArray, 0);
    //     // int res = 0;
    //     //
    //     // for (int i = nums.length - 1; i >= 0; i--) {
    //     //     int pos = Arrays.binarySearch(copy, nums[i]) + 1;
    //     //     res += get(treeArray, pos - 1);
    //     //     add(treeArray, pos);
    //     // }
    //     //
    //     // return res;
    //
    //
    //     TreeSet<Long> allNums = new TreeSet<>();
    //     for (int num : nums) {
    //         allNums.add((long) num);
    //         allNums.add((long) num << 1);
    //     }
    //     int[] treeArray = new int[allNums.size() + 1];
    //     HashMap<Long, Integer> hashMap = new HashMap<>();
    //     int begin = 1;
    //     for (Long num : allNums) {
    //         hashMap.put(num, begin++);
    //     }
    //     int ans = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         int left = hashMap.get(nums[i] * 2L);
    //         int right = allNums.size();
    //         ans += get(treeArray, right) - get(treeArray, left);
    //         left = hashMap.get((long) nums[i]);
    //         add(treeArray, left);
    //     }
    //     return ans;
    // }

    private void add(int[] treeArray, int pos) {
        while (pos < treeArray.length) {
            treeArray[pos]++;
            pos += lowBit(pos);
        }
    }

    private int get(int[] treeArray, int pos) {
        int res = 0;
        while (pos > 0) {
            res += treeArray[pos];
            pos -= lowBit(pos);
        }
        return res;
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = {2,4,3,5,1};
        reversePairs.reversePairs(nums);
    }
}
