package array;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ans = nums[i];
                count++;
            } else if (nums[i] == ans) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == ans) {
                count++;
            }
        }
        return (count << 1) > nums.length ? ans : -1;
    }
}
