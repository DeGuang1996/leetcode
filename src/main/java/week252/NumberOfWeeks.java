package week252;

import java.util.Arrays;

public class NumberOfWeeks {

    public long numberOfWeeks(int[] milestones) {
        long ans = 0;
        Arrays.sort(milestones);
        for (int i = 0; i < milestones.length; i++) {
            if (i != milestones.length - 1) {
                ans += milestones[i];
            } else {
                ans += Math.min(ans + 1, milestones[i]);
            }
        }
        return ans;
    }
}
