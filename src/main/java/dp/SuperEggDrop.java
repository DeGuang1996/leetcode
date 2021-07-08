package dp;

import java.util.HashMap;

public class SuperEggDrop {

    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int superEggDrop(int k, int n) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        int key = n * 1000 + k;
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }

        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int leftValue = superEggDrop(k - 1, mid - 1);
            int rightValue = superEggDrop(k, n - mid);
            if (leftValue < rightValue) {
                left = mid;
            } else if (leftValue > rightValue){
                right = mid;
            } else {
                left = right = mid;
            }
        }
        int res = Math.min(Math.max(superEggDrop(k - 1, left - 1), superEggDrop(k, n - left)),
                Math.max(superEggDrop(k - 1, right - 1), superEggDrop(k, n - right))) + 1;
        hashMap.put(key, res);
        return res;
    }
}
