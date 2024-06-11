package everyday;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums.length > nums[i] && nums[nums[i]] != nums[i]) {
                swap(i, nums[i], nums);
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    private void swap(int i, int j, int[] nums) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        MissingNumber missingNumber = new MissingNumber();
        missingNumber.missingNumber(nums);
    }
}
