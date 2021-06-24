package string;

import java.util.Arrays;

public class MaximumRemovals {

    private boolean isSubSeq(String s, String p) {
        int i = 0, j = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j >= p.length()) {
                return true;
            }
        }
        return false;
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            StringBuilder temp = new StringBuilder();
            boolean[] deleted = new boolean[s.length()];
            Arrays.fill(deleted, false);
            for (int i = 0; i <= mid; i++) {
                deleted[removable[i]] = true;
            }
            for (int i = 0; i < s.length(); i++) {
                if (!deleted[i]) {
                    temp.append(s.charAt(i));
                }
            }
            if (isSubSeq(temp.toString(), p)) {
                res = Math.max(res, mid + 1);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
