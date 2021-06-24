package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveOuterParentheses {

    public String removeOuterParentheses(String s) {
        // Stack<Character> stack = new Stack<>();
        // char[] chars = s.toCharArray();
        // List<StringBuilder> stringBuilderList = new ArrayList<>();
        // StringBuilder stringBuilder = new StringBuilder();
        // for (char temp : chars) {
        //     stringBuilder.append(temp);
        //     if (temp == '(') {
        //         stack.push(temp);
        //     } else {
        //         stack.pop();
        //         if (stack.empty()) {
        //             stringBuilderList.add(new StringBuilder(stringBuilder.subSequence(1, stringBuilder.length() - 1)));
        //             stringBuilder = new StringBuilder("");
        //         }
        //     }
        // }
        // StringBuilder res = new StringBuilder();
        // stringBuilderList.forEach(item -> {
        //     res.append(item.toString());
        // });
        // return res.toString();

        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }

}
