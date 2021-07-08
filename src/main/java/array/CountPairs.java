package array;

import java.util.HashMap;

public class CountPairs {

    public int countPairs(int[] deliciousness) {
        int maxVal = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            maxVal = Math.max(maxVal, deliciousness[i]);
        }
        maxVal = maxVal << 1;
        HashMap<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        int MOD = (int) 1e9 + 7;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = 1; j <= maxVal; j = j << 1) {
                int left = j - deliciousness[i];
                ans = ans + count.getOrDefault(left, 0);
                ans %= MOD;
            }
            count.put(deliciousness[i], count.getOrDefault(deliciousness[i], 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = new String("111") + new String("222");
        s1.intern();
        String s2 = "111222";
        System.out.println(s1 == s2);
    }
}
