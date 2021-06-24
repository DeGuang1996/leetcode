package stack;

import java.util.Stack;

public class Trap {

    public int trap(int[] height) {
        if (height == null || height.length == 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            while (height[i] >= height[stack.peek()]) {
                int curHeight = height[stack.pop()];
                if (stack.empty()) {
                    break;
                }
                int curWidth = i - stack.peek() - 1;
                res += (Math.min(height[i], height[stack.peek()]) - curHeight) * curWidth;
            }
            stack.push(i);
        }
        return res;
    }
}
