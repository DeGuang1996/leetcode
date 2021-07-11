package doubleweek56;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class NearestExit {

    private int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;
    private HashSet<Integer> target = new HashSet<>();
    private HashSet<Integer> visited = new HashSet<>();

    public int nearestExit(char[][] maze, int[] entrance) {
        int ans = 0;
        rows = maze.length;
        cols = maze[0].length;
        HashSet<Integer> cur = new HashSet<>();
        cur.add(getIndex(entrance[0], entrance[1]));

        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == '.') {
                target.add(getIndex(i, 0));
            }
            if (maze[i][cols - 1] == '.') {
                target.add(getIndex(i, cols - 1));
            }
        }
        for (int i = 0; i < cols; i++) {
            if (maze[0][i] == '.') {
                target.add(getIndex(0, i));
            }
            if (maze[rows - 1][i] == '.') {
                target.add(getIndex(rows - 1, i));
            }
        }
        target.remove(getIndex(entrance[0], entrance[1]));

        while (!cur.isEmpty()) {
            if (cur.size() > target.size()) {
                HashSet<Integer> temp = cur;
                cur = target;
                target = temp;
            }
            HashSet<Integer> next = new HashSet<>();
            for (int now : cur) {
                visited.add(now);
                for (int k = 0; k < dirs.length; k++) {
                    if (isValid(now / cols, now % cols, k, maze)) {
                        int nextX = now / cols + dirs[k][0];
                        int nextY = now % cols + dirs[k][1];
                        if (target.contains(getIndex(nextX, nextY))) {
                            return ans + 1;
                        }
                        next.add(nextX * cols + nextY);
                    }
                }
            }
            cur = next;
            ans++;
        }
        return -1;
    }

    private int getIndex(int x, int y) {
        return x * cols + y;
    }

    private boolean isValid(int x, int y, int k, char[][] maze) {
        int nextX = x + dirs[k][0];
        int nextY = y + dirs[k][1];
        if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || visited.contains(getIndex(nextX, nextY))) {
            return false;
        }
        return maze[nextX][nextY] == '.';
    }

    public static void main(String[] args) {
        char[][] maze = {{'+','.','+','+','+','+','+'},{'+','.','+','.','.','.','+'},{'+','.','+','.','+','.','+'},{'+','.','.','.','.','.','+'},{'+','+','+','+','.','+','.'}};
        NearestExit nearestExit = new NearestExit();
        nearestExit.nearestExit(maze, new int[]{0,1});
    }
}
