package week244;

import java.util.Arrays;
import java.util.TreeMap;

public class FindRotation {

    public int minFlips(String s) {
        String seq = "01";
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += s.charAt(i) == seq.charAt(i % 2) ? 0 : 1;
        }
        int res = Math.min(cnt, s.length() - cnt);

        int n = s.length();
        s += s;
        for (int i = 0; i < n; i++) {
            cnt -= (s.charAt(i) == seq.charAt(i % 2) ? 0 : 1);
            cnt += (s.charAt(i + n) == seq.charAt((i + n) % 2) ? 0 : 1);
            int temp = Math.min(cnt, s.length() - cnt);
            res = Math.min(res, temp);
        }
        return res;
    }

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : nums) {
            if (treeMap.containsKey(i)) {
                treeMap.put(i, treeMap.get(i) + 1);
            } else {
                treeMap.put(i, 1);
            }
        }
        int res = 0;
        int count = 0;
        for (Integer i : treeMap.keySet()) {
            res += count * treeMap.get(i);
            count++;
        }
        return res;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i <= 2 * mat.length; i++) {
            if (cmp(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }

    private void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private boolean cmp(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1}, {0,1}};
        int[][] target = {{1,1}, {1,0}};
        FindRotation findRotation = new FindRotation();
        findRotation.findRotation(mat, target);
    }
}
