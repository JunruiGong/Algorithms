package LeetCode;

/**
 * Leetcode-200-Number of Islands-Medium
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 */
public class NumberofIslands {
                                //  左      右       下       上
                                final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, grid.length, grid[0].length);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int x, int y, int rows, int cols) {

        // 超过边界，返回
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return;
        }

        // 该地点为水，或者已经被访问过，返回
        if (grid[x][y] == '0') {
            return;
        }

        // 将该点设为0
        grid[x][y] = '0';

        // 分别对该点的上下左右进行dfs
        for (int[] dir : dirs) {
            int neiX = dir[0] + x;
            int neiY = dir[1] + y;

            dfs(grid, neiX, neiY, rows, cols);
        }
    }
}
