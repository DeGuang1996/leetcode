package doubleweek54;

import java.util.Arrays;

public class LargestMagicSquare {

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] rowPreSum = new int[m][n + 1];
        for (int[] num : rowPreSum) {
            Arrays.fill(num, 0);
        }
        int[][] colPreSum = new int[n][m + 1];
        for (int[] num : colPreSum) {
            Arrays.fill(num, 0);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPreSum[i][j + 1] = rowPreSum[i][j] + grid[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colPreSum[j][i + 1] = colPreSum[j][i] + grid[i][j];
            }
        }
        
        int res = 1;
        int maxRes = Math.min(m, n);
        for (int i = 2; i <= maxRes; i++) {
            boolean find = false;
            for (int j = 0; j <= m - i; j++) {
                if (find) {
                    break;
                }
                for (int k = 0; k <= n - i; k++) {
                    if (find) {
                        break;
                    }
                    int sum = rowPreSum[j][j + i] - rowPreSum[j][j];
                    int l = 0;
                    for (; l < i; l++) {
                        int rowSum = rowPreSum[j + l][k + i] - rowPreSum[j + l][k];
                        int colSum = colPreSum[k + l][j + i] - colPreSum[k + l][j];
                        if (!(rowSum == colSum && rowSum == sum)) {
                            break;
                        }
                    }
                    if (l == i) {
                        int diagonal = 0;
                        for (int o = 0; o < i; o++) {
                            diagonal += grid[j + o][k + o];
                        }
                        int revDiagonal = 0;
                        for (int o = 0; o < i; o++) {
                            revDiagonal += grid[j + o][k + i - o - 1];
                        }
                        if (diagonal == revDiagonal && diagonal == sum) {
                            find = true;
                        }
                    }
                }
            }
            if (find) {
                res = Math.max(res, i);
            }
        }
        return res;
    }
}
