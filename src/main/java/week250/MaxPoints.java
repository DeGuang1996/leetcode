package week250;

public class MaxPoints {

    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < m; i++) {
            long[] cur = new long[n];
            long lMax = 0, rMax = 0;
            for (int j = 0; j < n; j++) {
                lMax = Math.max(lMax - 1, dp[j]);
                cur[j] = Math.max(cur[j], lMax);
            }
            for (int j = n - 1; j >= 0; j--) {
                rMax = Math.max(rMax - 1, dp[j]);
                cur[j] = Math.max(cur[j], rMax);
            }
            for (int j = 0; j < n; j++) {
                dp[j] = cur[j] + points[i][j];
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{1,2,3},{1,5,1},{3,1,1}};
        MaxPoints maxPoints = new MaxPoints();
        maxPoints.maxPoints(points);
    }
}
