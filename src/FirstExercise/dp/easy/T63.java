package FirstExercise.dp.easy;

public class T63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1){
                break;
            }
            dp[0][j] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1){
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
