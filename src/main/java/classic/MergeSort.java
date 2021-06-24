package classic;

import java.util.Comparator;
import java.util.TreeSet;

public class MergeSort {

    private static void internalMergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            internalMergeSort(arr, temp, left, mid);
            internalMergeSort(arr, temp, mid + 1, right);
            mergeSortedArray(arr, temp, left, mid, right);
        }
    }

    private static void mergeSortedArray(int arr[], int temp[], int left, int mid, int right) {
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < k; l++) {
            arr[left + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int n = 20;
        int[] nums = new int[1 << n];
        for (int i = (1 << n) - 1; i >= 0; i--) {
            nums[i] = (1 << n) - i;
        }

        int[] temp = new int[1 << n];

        long startTime = System.currentTimeMillis();
        internalMergeSort(nums, temp, 0, (1 << n) - 1);
        long endTime = System.currentTimeMillis();

        System.out.println("merge sort sum:" + (endTime - startTime) + " ms.");

        // for (int num : nums) {
        //     System.out.println(num);
        // }
    }
}
