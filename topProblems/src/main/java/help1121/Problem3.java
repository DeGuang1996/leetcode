package help1121;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {

    private static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        calcXOREqual(nums);
        System.out.println(ans);
    }

    public static void calcXOREqual(int[] nums) {
        int total = 0;
        int sum = 0;
        for (int num : nums) {
            total ^= num;
            sum += num;
        }
        if (total != 0) {
            ans = -1;
            return;
        }
        Arrays.sort(nums);
        dfs(total, sum, 0, 0, nums);
    }

    private static void dfs(int total, int sum, int cur, int left, int[] nums) {
        if (total == left && cur != 0) {
           ans = Math.max(ans, sum);
           return;
        }
        if (cur >= nums.length) {
            return;
        }
        if (sum <= ans) {
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            total ^= nums[i];
            sum -= nums[i];
            left ^= nums[i];
            dfs(total, sum, i + 1, left, nums);
            left ^= nums[i];
            sum += nums[i];
            total ^= nums[i];
        }
    }
}
