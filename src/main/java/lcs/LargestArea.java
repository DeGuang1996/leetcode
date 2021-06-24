package lcs;

public class LargestArea {

    public int largestArea(String[] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '0' && !visited[i][j]) {
                    visited[i][j] = true;
                    if (i + 1 < grid.length && grid[i + 1].charAt(j) != '0') {
                        markUp(grid, visited, i + 1, j, grid[i + 1].charAt(j));
                    }
                    if (i - 1 >= 0 && grid[i - 1].charAt(j) != '0') {
                        markUp(grid, visited, i - 1, j, grid[i - 1].charAt(j));
                    }
                    if (j + 1 < grid[i].length() && grid[i].charAt(j + 1) != '0') {
                        markUp(grid, visited, i, j + 1, grid[i].charAt(j + 1));
                    }
                    if (j - 1 >= 0 && grid[i].charAt(j - 1) != '0') {
                        markUp(grid, visited, i, j - 1, grid[i].charAt(j - 1));
                    }
                } else if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length() - 1) && !visited[i][j]) {
                    markUp(grid, visited, i, j, grid[i].charAt(j));
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (!visited[i][j]) {
                    res = Math.max(dfs(grid, visited, i, j, grid[i].charAt(j)), res);
                }
            }
        }
        return res;
    }

    private int dfs(String[] grid, boolean[][] visited, int i, int j, char mark) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length() || visited[i][j] || grid[i].charAt(j) != mark) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(grid, visited, i + 1, j, mark) + dfs(grid, visited, i - 1, j, mark) + dfs(grid, visited, i, j + 1, mark) + dfs(grid, visited, i, j - 1, mark);
    }

    private void markUp(String[] grid, boolean[][] visited, int i, int j, char mark) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length() || visited[i][j] || grid[i].charAt(j) != mark) {
            return;
        }
        visited[i][j] = true;
        StringBuilder stringBuilder = new StringBuilder(grid[i]);
        stringBuilder.setCharAt(j, '0');
        grid[i] = stringBuilder.toString();
        markUp(grid, visited, i + 1, j, mark);
        markUp(grid, visited, i - 1, j, mark);
        markUp(grid, visited, i, j + 1, mark);
        markUp(grid, visited, i, j - 1, mark);
    }

    public static void main(String[] args) {
        String[] grid = {"11111100000","21243101111","21224101221","11111101111"};
        LargestArea area = new LargestArea();
        System.out.println(area.largestArea(grid));
    }
}
