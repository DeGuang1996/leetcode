package datastructure;

public class FindKthNumber {

    public int findKthNumber(int n, int k) {
        int count = 1;
        int prefix = 1;
        while (count < k) {
            int curCount = getCount(prefix, n);
            if (curCount + count > k) {
                prefix *= 10;
                count++;
            } else {
                prefix++;
                count += curCount;
            }
        }
        return prefix;
    }

    private int getCount(int prefix, int n) {
        int count = 0;
        long cur = prefix;
        long next = cur + 1;
        while (cur <= n) {
            count += Math.min(n + 1, next) - cur;
            next *= 10;
            cur *= 10;
        }
        return count;
    }
}
