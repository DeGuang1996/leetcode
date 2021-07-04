package string;

import java.util.Stack;

public class ReverseParentheses {

    public String reverseParentheses(String s) {
        // Stack<Integer> stack = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == '(') {
        //         stack.push(i);
        //     } else if (s.charAt(i) == ')') {
        //         int left = stack.pop();
        //         s = s.substring(0, left) + new StringBuilder(s.substring(left + 1, i)).reverse().toString() + s.substring(i + 1);
        //         i -= 2;
        //     }
        // }
        // return s;

        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0, step = 1;
        while (index < s.length()) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                stringBuilder.append(s.charAt(index));
            }
            index += step;
        }
        return stringBuilder.toString();
    }
}
