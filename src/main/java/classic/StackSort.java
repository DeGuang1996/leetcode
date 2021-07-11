package classic;

import java.util.ArrayList;
import java.util.Collections;

public class StackSort {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < (1 << 10); i++) {
            nums.add((1 << 10) - i);
        }
        stackSortCom(nums);
        nums.forEach(System.out::println);
    }

    public static void makeStack(ArrayList<Integer> nums, int begin, int end) {
        while (begin <= end) {
            int next = begin * 2;
            if (next + 1 < nums.size() && nums.get(next) < nums.get(next + 1)) {
                next++;
            }
            if (next <= end && nums.get(begin) < nums.get(next)) {
                Collections.swap(nums, begin, next);
                begin = next;
            } else {
                break;
            }
        }
    }

    public static void buildStack(ArrayList<Integer> nums) {
        for (int i = nums.size() / 2; i >= 1; i--) {
            makeStack(nums, i, nums.size() - 1);
        }
    }

    public static void stackSortCom(ArrayList<Integer> nums) {
        nums.add(0, Integer.MAX_VALUE);
        buildStack(nums);
        for (int i = nums.size() - 1; i >= 2; i--) {
            Collections.swap(nums, 1, i);
            makeStack(nums, 1, i - 1);
        }
    }
}
