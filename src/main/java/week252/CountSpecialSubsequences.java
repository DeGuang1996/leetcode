package week252;

public class CountSpecialSubsequences {

    public int countSpecialSubsequences(int[] nums) {
        int MOD = (int) (1e9 + 7);
        int f0 = 0, f1 = 0, f2 = 0;
        for (int num : nums) {
            if (num == 0) {
                f0 = (2 * f0 % MOD + 1) % MOD;
            } else if (num == 1) {
                f1 = (f0 + 2 * f1 % MOD) % MOD;
            } else {
                f2 = (f1 + 2 * f2 % MOD) % MOD;
            }
        }
        return f2;
    }
}
