package graph;

import java.util.Arrays;

public class NumIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] found = new boolean[grid.length][grid[0].length];
        for (boolean[] booleans : found) {
            Arrays.fill(booleans, false);
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !found[i][j]) {
                    dfs(grid, found, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, boolean[][] found, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }
        if (grid[i][j] == '0' || found[i][j]) {
            return;
        }
        found[i][j] = true;
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            dfs(grid, found, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, found, i - 1, j);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
            dfs(grid, found, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, found, i, j - 1);
        }
    }
}
