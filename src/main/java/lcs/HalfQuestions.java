package lcs;

import java.util.Arrays;
import java.util.Comparator;

public class HalfQuestions {

    public int halfQuestions(int[] questions) {
        Integer[] nums = new Integer[1024];
        Arrays.fill(nums, 0);
        for (int question : questions) {
            nums[question]++;
        }
        Arrays.sort(nums, (num1, num2) -> num2 - num1);
        int res = 0;
        int left = questions.length / 2;
        for (int num : nums) {
            left -= num;
            res++;
            if (left <= 0) {
                break;
            }
        }
        return res;
    }
}
