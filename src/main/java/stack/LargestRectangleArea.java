package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        newHeights[0] = 0;
        newHeights[heights.length + 1] = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int res = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while (newHeights[stack.peek()] > newHeights[i]) {
                int curHeight = newHeights[stack.pop()];
                int curWidth = i - stack.peek() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.push(i);
        }
        return res;
    }
}
