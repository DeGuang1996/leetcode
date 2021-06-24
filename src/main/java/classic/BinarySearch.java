package classic;

import java.util.ArrayList;
import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        // Random random = new Random();
        for (int i = 0; i < (1 << 10); i++) {
            nums.add(i);
        }
        for (int i = 0; i < (1 << 10); i++) {
            System.out.println(binarySearchCom(nums, i));
        }
    }

    public static int binarySearchCom(ArrayList<Integer> nums, int key) {
        int left = 0, right = nums.size() - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums.get(mid) == key) {
                return mid;
            } else if (nums.get(mid) > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
