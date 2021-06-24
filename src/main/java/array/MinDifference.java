package array;

class ArrayTree {
    private int n;
    private int[] sum;

    public ArrayTree(int n) {
        this.n = n;
        this.sum = new int[n + 1];
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    public void update(int pos) {
        while (pos < sum.length) {
            sum[pos]++;
            pos += lowBit(pos);
        }
    }

    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += sum[i];
            i -= lowBit(i);
        }
        return res;
    }

    public int queryPeriod(int i, int j) {
        return query(j) - query(i);
    }
}

public class MinDifference {

    public int[] minDifference(int[] nums, int[][] queries) {
        // final int MAX_VALUE = 100;
        // int[][] preSum = new int[nums.length + 1][MAX_VALUE + 1];
        // for (int i = 1; i <= nums.length; i++) {
        //     for (int j = 1; j <= MAX_VALUE; j++) {
        //         if (j == nums[i - 1]) {
        //             preSum[i][j] = 1 + preSum[i - 1][j];
        //         } else {
        //             preSum[i][j] = preSum[i - 1][j];
        //         }
        //     }
        // }
        // int[] res = new int[queries.length];
        // for (int i = 0; i < queries.length; i++) {
        //     int left = queries[i][0];
        //     int right = queries[i][1];
        //     int last = 0;
        //     int best = Integer.MAX_VALUE;
        //     for (int j = 1; j <= MAX_VALUE; j++) {
        //         int cur = preSum[right + 1][j] - preSum[left][j];
        //         if (cur > 0) {
        //             if (last != 0) {
        //                 best = Math.min(best, j - last);
        //             }
        //             last = j;
        //         }
        //     }
        //     if (best == Integer.MAX_VALUE) {
        //         res[i] = -1;
        //     } else {
        //         res[i] = best;
        //     }
        // }
        // return res;

        final int MAX_VALUE = 100;
        ArrayTree[] arrayTrees = new ArrayTree[MAX_VALUE + 1];
        for (int i = 0; i < arrayTrees.length; i++) {
            arrayTrees[i] = new ArrayTree(nums.length);
        }
        for (int i = 0; i < nums.length; i++) {
            arrayTrees[nums[i]].update(i + 1);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0] + 1;
            int right = queries[i][1] + 1;
            int last = 0;
            int best = Integer.MAX_VALUE;
            for (int j = 1; j <= MAX_VALUE; j++) {
                int cur = arrayTrees[j].queryPeriod(left, right - 1);
                if (cur > 0) {
                    if (last != 0) {
                        best = Math.min(best, j - last);
                    }
                    last = j;
                }
                if (best == Integer.MAX_VALUE) {
                    res[i] = -1;
                } else {
                    res[i] = best;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,8};
        int[][] queries = {{0,1},{1,2},{2,3},{0,3}};
        MinDifference minDifference = new MinDifference();
        minDifference.minDifference(nums, queries);
    }
}
