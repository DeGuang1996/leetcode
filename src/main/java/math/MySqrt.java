package math;

public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double num = x;
        double x0 = num, x1 = num;
        while (true) {
            x1 = 0.5 * (num / x0 + x0);
            if (Math.abs(x1 - x0) <= 1e-6) {
                break;
            }
            x0 = x1;
        }
        return (int) x1;
    }
}
