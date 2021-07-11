package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // int[] res = new int[nums.length - k + 1];
        // Deque<Integer> deque = new ArrayDeque<>();
        // for (int i = 0; i < nums.length; i++) {
        //     while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        //         deque.pollFirst();
        //     }
        //     while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        //         deque.pollLast();
        //     }
        //     deque.offerLast(i);
        //     if (i >= k - 1) {
        //         res[i - k + 1] = nums[deque.peekFirst()];
        //     }
        // }
        // return res;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((term1, term2) -> term2[0] - term1[0]);
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
            if (i >= k - 1) {
                while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] <= i - k) {
                    priorityQueue.poll();
                }
                res[i - k + 1] = priorityQueue.peek()[0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow(nums, 3);
    }
}
