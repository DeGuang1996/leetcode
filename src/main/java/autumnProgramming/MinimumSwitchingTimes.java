package autumnProgramming;

import java.util.HashMap;

public class MinimumSwitchingTimes {

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        HashMap<Integer, Integer> curr = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                curr.put(source[i][j], curr.getOrDefault(source[i][j], 0) + 1);
                need.put(target[i][j], need.getOrDefault(target[i][j], 0) + 1);
            }
        }
        int ans = 0;
        for (Integer key : need.keySet()) {
            int needCount = need.get(key);
            if (curr.containsKey(key)) {
                if (needCount - curr.get(key) > 0) {
                    ans += needCount - curr.get(key);
                }
            } else {
                ans += needCount;
            }
        }
        return ans;
    }
}
