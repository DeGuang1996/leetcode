package autumnProgramming;

public class FlipChess {

    private int n;
    private int m;

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public int flipChess(String[] chessboard) {
        n = chessboard.length;
        m = chessboard[0].length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chessboard[i].charAt(j) == '.') {
                    char[][] board = new char[n][m];
                    for (int k = 0; k < n; k++) {
                        board[k] = chessboard[k].toCharArray();
                    }
                    ans = Math.max(dfs(board, i, j), ans);
                }
            }
        }
        return ans;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private int dfs(char[][] board, int x, int y) {
        board[x][y] = 'X';
        int ans = 0;
        for (int i = 0; i < dirs.length; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            boolean isMark = false;
            boolean hasWhite = false;
            while (isValid(newX, newY)) {
                if (board[newX][newY] == 'O') {
                    hasWhite = true;
                    newX = newX + dirs[i][0];
                    newY = newY + dirs[i][1];
                } else if (hasWhite && board[newX][newY] == 'X') {
                    isMark = true;
                    break;
                } else {
                    break;
                }
            }
            if (isMark) {
                newX = x + dirs[i][0];
                newY = y + dirs[i][1];
                while (isValid(newX, newY) && board[newX][newY] == 'O') {
                    board[newX][newY] = 'X';
                    ans++;
                    newX = newX + dirs[i][0];
                    newY = newY + dirs[i][1];
                }
                newX = x + dirs[i][0];
                newY = y + dirs[i][1];
                while (isValid(newX, newY) && board[newX][newY] == 'X') {
                    ans += dfs(board, newX, newY);
                    newX = newX + dirs[i][0];
                    newY = newY + dirs[i][1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] chessboard = {".X.",".O.","XO."};
        FlipChess flipChess = new FlipChess();
        flipChess.flipChess(chessboard);
    }
}
