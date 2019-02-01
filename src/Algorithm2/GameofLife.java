package Algorithm2;

import org.junit.Test;

public class GameofLife {

    public void gameOfLife(int[][] board) {

        if (board == null || board[0].length < 1) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        int[][] livesBoard = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int livesNeighbor = livesNeighbors(board, i, j);
                livesBoard[i][j] = livesNeighbor;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && (livesBoard[i][j] < 2 || livesBoard[i][j] > 3)) {
                    board[i][j] = 0;
                } else if (board[i][j] == 0 && livesBoard[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }


    private int livesNeighbors(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        int lives = 0;

        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y];
            }
        }

        lives -= board[i][j];
        return lives;
    }

    @Test
    public void test() {

        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
    }
}
