package math;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculate {

    private HashMap<Character, Integer> comparator = new HashMap<>();

    private ArrayDeque<Integer> nums = new ArrayDeque<>();
    private ArrayDeque<Character> ops = new ArrayDeque<>();

    public int calculate(String s) {
        initComparator();

        s = s.replace(" ", "");
        StringBuilder expression = new StringBuilder(s);
        nums.addLast(0);

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                int num = expression.charAt(i) - '0';
                int j = i + 1;
                while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                    num = num * 10 + expression.charAt(j) - '0';
                    j++;
                }
                nums.addLast(num);
                i = j - 1;
            } else if (expression.charAt(i) == '(') {
                ops.addLast(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                while (ops.peekLast() != '(') {
                    doCalculate();
                }
                ops.pollLast();
            } else {
                if (i > 0 && comparator.get(expression.charAt(i - 1)) != null && expression.charAt(i - 1) != ')') {
                    nums.addLast(0);
                }
                while (!ops.isEmpty() && comparator.get(expression.charAt(i)) <= comparator.get(ops.peekLast())) {
                    doCalculate();
                }
                ops.addLast(expression.charAt(i));
            }
        }
        while (!ops.isEmpty()) {
            doCalculate();
        }
        return nums.peekLast();
    }

    private void initComparator() {
        comparator.put('(', 1);
        comparator.put('+', 2);
        comparator.put('-', 2);
        comparator.put('*', 3);
        comparator.put('/', 3);
        comparator.put(')', 4);
    }

    private void doCalculate() {
        int num1 = nums.pollLast();
        int num2 = nums.pollLast();
        int result = 0;
        char character = ops.pollLast();
        switch (character) {
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        nums.addLast(result);
    }


    private HashMap<String, List<Integer>> hashMap = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if (hashMap.containsKey(expression)) {
            return hashMap.get(expression);
        }
        List<Integer> curRes = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (Integer num1 : left) {
                    for (Integer num2 : right) {
                        switch (expression.charAt(i)) {
                            case '+':
                                curRes.add(num1 + num2);
                                break;
                            case '-':
                                curRes.add(num1 - num2);
                                break;
                            case '*':
                                curRes.add(num1 * num2);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (curRes.isEmpty()) {
            curRes.add(Integer.valueOf(expression));
        }
        hashMap.put(expression, new ArrayList<>(curRes));
        return curRes;
    }

    public static void main(String[] args) {
        String s = "2-1-1";
        Calculate calculate = new Calculate();
        calculate.diffWaysToCompute(s);
    }
}
