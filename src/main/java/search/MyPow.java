package search;

public class MyPow {

    public double myPow(double x, int n) {
        double res = 1;
        boolean isNes = n < 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return isNes ? 1 / res : res;
    }
}
