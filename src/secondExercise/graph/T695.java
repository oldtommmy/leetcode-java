package secondExercise.graph;

/**
 *  dfs 解决岛屿问题
 */
public class T695 {

    int count = 0;
    boolean[][] isVisited;
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count = 0;
                dfs(grid, i, j);
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    /**
     * 处理当前节点
     * @param grid 图
     * @param i 行
     * @param j 列
     */
    public void dfs(int[][] grid, int i, int j) {

        if (!check(grid, i, j) || isVisited[i][j] || grid[i][j] != 1) {
            return;
        }

        isVisited[i][j] = true;
        count++;
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
    }

    /**
     * 检查是否越界
     * @param grid 地图
     * @param i 行
     * @param j 列
     * @return boolean
     */
    public boolean check(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return false;
        }
        return true;
    }
}
