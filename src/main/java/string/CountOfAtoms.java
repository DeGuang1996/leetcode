package string;

import java.util.Stack;
import java.util.TreeMap;

public class CountOfAtoms {

    public String countOfAtoms(String formula) {
        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                TreeMap<String, Integer> treeMap = new TreeMap<>();
                stack.push(treeMap);
            } else if (formula.charAt(i) == ')') {
                TreeMap<String, Integer> treeMapPop = stack.pop();
                int j = ++i;
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    j++;
                }
                int count = 0;
                if (i == j) {
                    count = 1;
                } else {
                    count = Integer.parseInt(formula.substring(i, j));
                }
                TreeMap<String, Integer> treeMapCur = stack.peek();
                for (String str : treeMapPop.keySet()) {
                    treeMapCur.put(str, treeMapCur.getOrDefault(str, 0) + count * treeMapPop.get(str));
                }
                i = j - 1;
            } else if (Character.isUpperCase(formula.charAt(i))) {
                int j = i + 1;
                while (j < formula.length() && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String element = formula.substring(i, j);
                i = j;
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    j++;
                }
                int count = 0;
                if (i == j) {
                    count = 1;
                } else {
                    count = Integer.parseInt(formula.substring(i, j));
                }
                TreeMap<String, Integer> treeMapCur = stack.peek();
                treeMapCur.put(element, treeMapCur.getOrDefault(element, 0) + count);
                i = j - 1;
            }
        }
        TreeMap<String, Integer> treeMapPop = stack.pop();
        StringBuilder res = new StringBuilder();
        for (String str : treeMapPop.keySet()) {
            res.append(str);
            if (treeMapPop.get(str) > 1) {
                res.append(treeMapPop.get(str));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        CountOfAtoms countOfAtoms = new CountOfAtoms();
        System.out.println(countOfAtoms.countOfAtoms("Mg(OH)2"));
    }
}
