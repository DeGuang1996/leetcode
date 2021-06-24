package sort;

public class LowerBound {

    public static int lowerBound(int[] nums, int t) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (t > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int upperBound(int[] nums, int t) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (t >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[1024];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        System.out.println(lowerBound(nums, 1023));
        System.out.println(upperBound(nums, 1023));
    }
}
