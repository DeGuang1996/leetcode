package everyday;

public class GetSum {

    public int getSum(int a, int b) {
        while (a != 0) {
            int carry = (a & b) << 1;
            int xor = a ^ b;
            a = carry;
            b = xor;
        }
        return b;
    }
}
