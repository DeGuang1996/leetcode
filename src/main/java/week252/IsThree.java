package week252;

public class IsThree {

    public boolean isThree(int n) {
        int m = (int) Math.sqrt(n);
        return m * m == n && isPrimeNumber(m);
    }

    private boolean isPrimeNumber(int m) {
        if (m == 1) {
            return false;
        }
        if (m == 2 || m == 3) {
            return true;
        }
        for (int i = 2; i <= (int) Math.sqrt(m); i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }
}
