package everyday;

import java.util.HashMap;

public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        long plus = (long) numerator / (long) denominator;
        if (numerator % denominator == 0) {
            return String.valueOf(plus);
        }
        long multi = (long) numerator * denominator;
        StringBuilder ans = new StringBuilder();
        if (multi < 0 && plus == 0) {
            ans.append("-");
        }
        ans.append(plus).append(".");
        long startDec = numerator % denominator;
        HashMap<Long, Integer> hashMap = new HashMap<>();
        hashMap.put(startDec, ans.length());
        while (startDec != 0) {
            startDec *= 10;
            ans.append(Math.abs(startDec / denominator));
            long nextDec = startDec % denominator;
            if (hashMap.containsKey(nextDec)) {
                ans.insert(hashMap.get(nextDec), "(");
                ans.append(')');
                break;
            }
            hashMap.put(nextDec, ans.length());
            startDec = nextDec;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        System.out.println(fractionToDecimal.fractionToDecimal(-2147483648, -1));
    }
}
