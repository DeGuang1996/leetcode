package array;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] preSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[i - 1].length; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    preSum[i][j] = 0;
                } else {
                    preSum[i][j] = preSum[i][j - 1] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 1; i < preSum[0].length; i++) {
            int[] nums = new int[preSum.length + 1];
            for (int j = 1; j < preSum.length; j++) {
                nums[j] = preSum[j][i];
            }
            res = Math.max(res, getMaxRect(nums));
        }
        return res;
    }

    private int getMaxRect(int[] nums) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            while (stack.size() > 1 && nums[i] <= nums[stack.peek()]) {
                int height = nums[stack.pop()];
                int width = i - stack.peek() - 1;
                res = Math.max(res, width * height);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        maximalRectangle.maximalRectangle(matrix);
    }
}
