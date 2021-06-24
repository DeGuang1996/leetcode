package classic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < (1 << 10); i++) {
            // nums.add(random.nextInt(1 << 20));
            nums.add(i);
        }
        quickSortCom(nums, 0, nums.size() - 1);
        nums.forEach(System.out::println);
    }

    public static int partition(ArrayList<Integer> nums, int begin, int end) {
        // int pivot = nums.get(begin);
        // int idx = begin;
        // while (begin < end) {
        //     while (begin < end && nums.get(end) >= pivot) {
        //         end--;
        //     }
        //     while (begin < end && nums.get(begin) <= pivot) {
        //         begin++;
        //     }
        //     if (begin < end) {
        //         Collections.swap(nums, begin, end);
        //     }
        // }
        // Collections.swap(nums, idx, begin);
        // return begin;
        int mark = begin;
        int pivot = nums.get(begin);
        for (int i = begin; i <= end; i++) {
            if (nums.get(i) < pivot) {
                mark++;
                Collections.swap(nums, i, mark);
            }
        }
        Collections.swap(nums, begin, mark);
        return mark;
    }

    public static void quickSortCom(ArrayList<Integer> nums, int left, int right) {
        int idx = partition(nums, left, right);
        if (idx > left) {
            quickSortCom(nums, left, idx - 1);
        }
        if (idx < right) {
            quickSortCom(nums, idx + 1, right);
        }
    }
}
