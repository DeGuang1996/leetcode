package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumOfWays {

    public int numOfWays(int n) {
        ArrayList<Integer> types = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i != j && j != k) {
                        types.add(i * 9 + j * 3 + k);
                    }
                }
            }
        }
        int[][] baseType = new int[types.size()][types.size()];
        for (int i = 0; i < types.size(); i++) {
            int x1 = types.get(i) / 9, y1 = (types.get(i) - x1 * 9) / 3, z1 = types.get(i) % 3;
            for (int j = 0; j < types.size(); j++) {
                int x2 = types.get(j) / 9, y2 = (types.get(j) - x2 * 9) / 3, z2 = types.get(j) % 3;
                if (x1 != x2 && y1 != y2 && z1 != z2) {
                    baseType[i][j] = 1;
                }
            }
        }
        int[][] dp = new int[n + 1][types.size()];
        for (int i = 0; i < types.size(); i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < types.size(); j++) {
                for (int k = 0; k < types.size(); k++) {
                    if (baseType[j][k] == 1) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < types.size(); i++) {
            res = (res + dp[n][i]) % MOD;
        }
        return res;
    }

    private static final int MOD = (int) 1e9 + 7;
    private ArrayList<ArrayList<Integer>> types = new ArrayList<>();

    private void genValid(int m, ArrayList<Integer> path) {
        if (path.size() == m) {
            types.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < 3; j++) {
            if (path.isEmpty() || path.get(path.size() - 1) != j) {
                path.add(j);
                genValid(m, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(int i, int j, int m) {
        for (int k = 0; k < m; k++) {
            if (types.get(i).get(k).equals(types.get(j).get(k))) {
                return false;
            }
        }
        return true;
    }

    public int colorTheGrid(int m, int n) {
        genValid(m, new ArrayList<>());
        int[][] dp = new int[n + 1][types.size()];
        for (int i = 0; i < types.size(); i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < types.size(); j++) {
                for (int k = 0; k < types.size(); k++) {
                    if (isValid(j, k, m)) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < types.size(); i++) {
            ans += dp[n][i];
            ans %= MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        // NumOfWays numOfWays = new NumOfWays();
        // numOfWays.numOfWays(2);

        int[] nums = {1,2,3};
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
