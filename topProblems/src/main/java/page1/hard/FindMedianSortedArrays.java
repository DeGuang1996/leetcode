package page1.hard;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return (double) (calMedianSortedArrays(nums1, nums2, (m + n + 1) / 2, 0, 0) +
                calMedianSortedArrays(nums1, nums2, (m + n + 2) / 2, 0, 0)) / 2;
    }

    private int calMedianSortedArrays(int[] nums1, int[] nums2, int k, int idx1, int idx2) {
        if (idx1 >= nums1.length) {
            return nums2[idx2 + k - 1];
        } else if (idx2 >= nums2.length) {
            return nums1[idx1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[idx1], nums2[idx2]);
        }

        int num1 = idx1 + k / 2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[idx1 + k / 2 - 1];
        int num2 = idx2 + k / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[idx2 + k / 2 - 1];
        if (num1 > num2) {
            return calMedianSortedArrays(nums1, nums2, k - k / 2, idx1, idx2 + k / 2);
        } else {
            return calMedianSortedArrays(nums1, nums2, k - k / 2, idx1 + k / 2, idx2);
        }
    }
}
