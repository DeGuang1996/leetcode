package math;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {

                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        firstMissingPositive.firstMissingPositive(nums);
    }
}
