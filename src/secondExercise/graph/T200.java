package secondExercise.graph;

/**
 * dfs 岛屿问题
 */
public class T200 {

    int count = 0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 处理当前节点
     * @param grid 图
     * @param i 行
     * @param j 列
     */
    public boolean dfs(char[][] grid, int i, int j) {

        if (!check(grid, i, j) || grid[i][j] != '1') {
            return false;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        return true;
    }

    /**
     * 检查是否越界
     * @param grid 地图
     * @param i 行
     * @param j 列
     * @return boolean
     */
    public boolean check(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return false;
        }
        return true;
    }
}
