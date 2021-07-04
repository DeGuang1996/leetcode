package dp;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        // int res = 0;
        // int[] dp = new int[s.length()];
        //
        // for (int i = 1; i < s.length(); i++) {
        //     if (s.charAt(i) == ')') {
        //         if (s.charAt(i - 1) == '(') {
        //             dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
        //         }
        //         if (i > dp[i - 1] && s.charAt(i - 1) == ')') {
        //             if (s.charAt(i - dp[i - 1] - 1) == '(') {
        //                 dp[i] = dp[i - 1] + 2 + (i > dp[i - 1] + 1 ? dp[i - dp[i - 1] - 2] : 0);
        //             }
        //         }
        //     } else {
        //         dp[i] = 0;
        //     }
        //     res = Math.max(res, dp[i]);
        // }
        // return res;

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;

        // int res = 0;
        // int left = 0, right = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == '(') {
        //         left++;
        //     } else {
        //         right++;
        //     }
        //     if (left == right) {
        //         res = Math.max(res, left << 1);
        //     }
        //     if (right > left) {
        //         right = 0;
        //         left = 0;
        //     }
        // }
        // right = 0;
        // left = 0;
        // for (int i = s.length() - 1; i >= 0; i--) {
        //     if (s.charAt(i) == '(') {
        //         left++;
        //     } else {
        //         right++;
        //     }
        //     if (left == right) {
        //         res = Math.max(res, left << 1);
        //     }
        //     if (left > right) {
        //         right = 0;
        //         left = 0;
        //     }
        // }
        // return res;
    }
}
