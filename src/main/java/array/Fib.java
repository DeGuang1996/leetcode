package array;

public class Fib {

    // public int fib(int n) {
    //     final int MOD = (int) (1e9+7);
    //     if (n < 2) {
    //         return n;
    //     }
    //     int p = 0, q = 0, r = 1;
    //     for (int i = 2; i <= n; ++i) {
    //         p = q;
    //         q = r;
    //         r = (p + q) % MOD;
    //     }
    //     return r;
    // }

    static final int MOD = (int) (1e9+7);

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }
}
