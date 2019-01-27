package LeetCode;

/**
 * Leetcode-286-Walls and Gates-Medium
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF
 * as you may assume that the distance to a gate is less than 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 *
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 *   做法与leetcode-200相似
 */
public class WallsandGates {
    final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length < 1 || rooms[0].length < 1) {
            return;
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int x, int y, int val) {
        if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length) {
            return;
        }
        rooms[x][y] = val;

        for (int dir[] : dirs) {
            int dirX = dir[0] + x;
            int dirY = dir[1] + y;
            dfs(rooms, dirX, dirY, val + 1);
        }
    }
}
