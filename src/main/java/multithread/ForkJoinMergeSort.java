package multithread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinMergeSort extends RecursiveTask<Integer> {

    private int[] nums;
    private int[] temp;
    private int left;
    private int right;

    public ForkJoinMergeSort(int[] nums, int[] temp, int left, int right) {
        this.nums = nums;
        this.temp = temp;
        this.left = left;
        this.right = right;
    }

    public void mergeSortedArray(int arr[], int temp[], int left, int mid, int right) {
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

    @Override
    protected Integer compute() {
        if (left < right) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int mid = this.left + ((right - left) >> 1);

            ForkJoinMergeSort leftPart = new ForkJoinMergeSort(nums, temp, left, mid);
            ForkJoinMergeSort rightPart = new ForkJoinMergeSort(nums, temp, mid + 1, right);
            invokeAll(leftPart, rightPart);

            mergeSortedArray(nums, temp, left, mid, right);

            return mid;
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 20;
        int[] nums = new int[1 << n];
        for (int i = (1 << n) - 1; i >= 0; i--) {
            nums[i] = (1 << n) - i;
        }

        int[] temp = new int[1 << n];

        ForkJoinPool fjp = new ForkJoinPool(16);
        ForkJoinTask<Integer> task = new ForkJoinMergeSort(nums, temp, 0, (1 << n) - 1);

        long startTime = System.currentTimeMillis();
        fjp.invoke(task);
        long endTime = System.currentTimeMillis();

        System.out.println("fork/join sum:" + (endTime - startTime) + " ms.");

        // for (int num : nums) {
        //     System.out.println(num);
        // }
    }
}
