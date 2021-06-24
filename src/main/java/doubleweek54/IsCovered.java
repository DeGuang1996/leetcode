package doubleweek54;

import java.util.Arrays;

public class IsCovered {

    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] list = new boolean[51];
        Arrays.fill(list, false);
        for (int i = 0; i < ranges.length; i++) {
            for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                list[j] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!list[i]) {
                return false;
            }
        }
        return true;
    }

    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k) {
                return i;
            }
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0) {
                return i;
            }
        }
        return 0;
    }

}
