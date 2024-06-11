package help1121;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        String input = sc.nextLine();
        Scanner in = new Scanner(input);
        while (in.hasNextLine()) {
            int num = in.nextInt();
            nums.add(num);
        }
        System.out.println(calcMaxArea(nums));
    }

    public static long calcMaxArea(ArrayList<Integer> nums) {
        Stack<Integer> stack = new Stack<>();
        long ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int height = nums.get(i);
            while (!stack.isEmpty() && nums.get(stack.peek()) >= height) {
                ans = Math.max(ans, (long) height * (i - stack.peek()));
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans = Math.max(ans, (long) height * (i));
            }
            stack.push(i);
        }
        return ans;
    }
}
