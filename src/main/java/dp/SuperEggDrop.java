package dp;

import java.util.HashMap;

public class SuperEggDrop {

    private HashMap<Integer, Integer> cache = new HashMap<>();

    public int superEggDrop(int k, int n) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        if (cache.containsKey(n * 1000 + k)) {
            return cache.get(n * 1000 + k);
        }
        int left = 1, right = n, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            int leftValue = superEggDrop(k - 1, mid - 1);
            int rightValue = superEggDrop(k, n - mid);
            if (leftValue < rightValue) {
                left = mid;
            } else if (leftValue > rightValue) {
                right = mid;
            } else {
                left = right = mid;
            }
        }
        int ans = Math.min(Math.max(superEggDrop(k - 1, left - 1), superEggDrop(k, n - left)),
                Math.max(superEggDrop(k - 1, right - 1), superEggDrop(k, n - right))) + 1;
        cache.put(n * 1000 + k, ans);
        return ans;
    }

    public static void main(String[] args) {
        SuperEggDrop superEggDrop = new SuperEggDrop();
        superEggDrop.superEggDrop(2, 6);
    }
}
