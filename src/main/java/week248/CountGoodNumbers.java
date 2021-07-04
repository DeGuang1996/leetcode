package week248;

public class CountGoodNumbers {

    private final int MOD = (int) 1e9 + 7;

    public int countGoodNumbers(long n) {
        int ans = 0;
        int temp = quickPow(20, n / 2);
        if (n % 2 == 1) {
            for (int i = 0; i < 5; i++) {
                ans += temp;
                ans %= MOD;
            }
        } else {
            ans = temp;
        }
        return ans;
    }

    private int quickPow(long m, long n) {
        if (n == 0) {
            return 1;
        }
        long ans = 1L;
        long base = m % MOD;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base % MOD) * (base % MOD) % MOD;
            n >>= 1;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        CountGoodNumbers countGoodNumbers = new CountGoodNumbers();
        countGoodNumbers.countGoodNumbers(806166225460393L);
    }
}
