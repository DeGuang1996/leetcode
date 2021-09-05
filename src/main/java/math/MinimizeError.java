package math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

public class MinimizeError {

    public String minimizeError(String[] prices, int target) {
        int maxSum = 0;
        int minSum = 0;
        for (String num : prices) {
            maxSum += Math.ceil(Double.parseDouble(num));
            minSum += Math.floor(Double.parseDouble(num));
        }
        if (target < minSum || target > maxSum) {
            return "-1";
        }
        int dis = maxSum - target;
        BigDecimal ans = BigDecimal.ZERO;
        ArrayList<BigDecimal> arrayList = new ArrayList<>();

        for (String num : prices) {
            if (!num.endsWith("000")) {
                arrayList.add(BigDecimal.valueOf(Double.parseDouble(num.substring(num.indexOf(".") + 1)) / 1000));
            }
        }
        Collections.sort(arrayList);

        int begin = 0;
        while (begin < dis) {
            ans = ans.add(arrayList.get(begin));
            begin++;
        }
        while (begin < arrayList.size()) {
            ans = ans.add(BigDecimal.ONE.subtract(arrayList.get(begin)));
            begin++;
        }
        return ans.setScale(3, RoundingMode.HALF_UP).toString();
    }

    public static void main(String[] args) {
        String[] prices = {"0.700","2.800","4.900"};
        MinimizeError minimizeError = new MinimizeError();
        minimizeError.minimizeError(prices, 8);
    }
}
