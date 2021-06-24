package treearray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int[] treeArray = new int[nums.length + 1];
        Arrays.fill(treeArray, 0);
        List<Integer> res = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = Arrays.binarySearch(copy, nums[i]) + 1;
            res.add(get(treeArray, pos - 1));
            add(treeArray, pos);
        }

        Collections.reverse(res);
        return res;
    }

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
}
