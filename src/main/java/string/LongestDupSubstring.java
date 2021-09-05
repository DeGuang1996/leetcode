package string;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestDupSubstring {

    public String longestDupSubstring(String s) {
        int n = s.length();
        s = " " + s;
        int p = 998244353;
        int q = (int) (1e9 + 7);
        long[] sHash = new long[n + 1];
        long[] sHash2 = new long[n + 1];
        long[] p131 = new long[n + 1];
        long[] p1312 = new long[n + 1];
        p131[0] = 1;
        p1312[0] = 1;
        for (int i = 1; i <= n; i++) {
            sHash[i] = (sHash[i - 1] * 131 + s.charAt(i) - 'a' + 1) % p;
            sHash2[i] = (sHash2[i - 1] * 131 + s.charAt(i) - 'a' + 1) % q;
            p131[i] = p131[i - 1] * 131 % p;
            p1312[i] = p1312[i - 1] * 131 % q;
        }

        int left = 1, right = n + 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (search(s, sHash, p131, sHash2, p1312, mid, p, q) != -1) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int start = search(s, sHash, p131, sHash2, p1312, left, p, q);
        if (start == -1) {
            return "";
        }
        return s.substring(start, start + left);
    }

    private int search(String s, long[] sHash, long[] p131, long[] sHash2, long[] p1312, int len, int p, int q) {
        HashMap<Long, Long> hashMap = new HashMap<>();
        hashMap.put(calcHash(sHash, p131, p, 1, len), calcHash2(sHash2, p1312, q, 1, len));

        for (int i = 2; i <= s.length() - len; i++) {
            long hash = calcHash(sHash, p131, p, i, i + len - 1);
            long hash2 = calcHash2(sHash2, p1312, q, i, i + len - 1);
            if (hashMap.containsKey(hash) && hashMap.get(hash) == hash2) {
                return i;
            }
            hashMap.put(hash, hash2);
        }
        return -1;
    }

    private long calcHash(long[] sHash, long[] p131, int p, int l, int r) {
        return ((sHash[r] - sHash[l - 1] * p131[r - l + 1] % p) + p) % p;
    }

    private long calcHash2(long[] sHash, long[] p131, int q, int l, int r) {
        return ((sHash[r] - sHash[l - 1] * p131[r - l + 1] % q) + q) % q;
    }

    public int findMiddleIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0, rightSum = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftSum += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    private int m;
    private int n;

    public int[][] findFarmland(int[][] land) {
        m = land.length;
        n = land[0].length;
        boolean[][] visited = new boolean[land.length][land[0].length];
        ArrayList<int[]> ans = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int end = dfs(visited, land, i, j);
                    ans.add(new int[] {i, j, end / n, end % n});
                }
            }
        }
        int[][] res = new int[ans.size()][4];
        for (int i = 0; i < ans.size(); i++) {
            System.arraycopy(ans.get(i), 0, res[i], 0, 4);
        }
        return res;
    }

    private int dfs(boolean[][] visited, int[][] land, int x, int y) {
        if (x < 0 || x >= visited.length || y < 0 || y >= visited[x].length || land[x][y] == 0 || visited[x][y]) {
            return -1;
        }
        visited[x][y] = true;
        int ans = x * n + y;
        int up = dfs(visited, land, x - 1, y);
        ans = Math.max(up, ans);
        int down = dfs(visited, land, x + 1, y);
        ans = Math.max(down, ans);
        int left = dfs(visited, land, x, y - 1);
        ans = Math.max(left, ans);
        int right = dfs(visited, land, x, y + 1);
        ans = Math.max(right, ans);
        return ans;
    }

}
