package stack;

import java.util.Stack;

public class RemoveDuplicates {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char temp : chars) {
            if (!stack.empty() && stack.peek() == temp) {
                stack.pop();
            } else {
                stack.push(temp);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.empty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
