package array;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;

        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2;
    }

    private double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1) >= nums1.length ? Integer.MAX_VALUE : nums1[i + k / 2 - 1];
        int midVal2 = (j + k / 2 - 1) >= nums2.length ? Integer.MAX_VALUE : nums2[j + k / 2 - 1];
        if (midVal1 > midVal2) {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        } else {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        findMedianSortedArrays.findMedianSortedArrays(num1, num2);
    }
}
