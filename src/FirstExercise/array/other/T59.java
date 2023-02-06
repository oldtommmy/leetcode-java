package FirstExercise.array.other;

/**
 * LeetCode 59 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix-ii/
 */
@SuppressWarnings({"all"})
public class T59 {
    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];
        int loop = 0; //循环次数
        int startX = 0, startY = 0; //每个圈的起始位置
        int count = 1; //填充数字
        int i = 0;

        while (loop < n / 2) {

            //模拟上方从左到右 遵循左闭右开
            for (i = startY; i < n - loop - 1; i++) {
                ans[startX][i] = count++;
            }

            //模拟右方从上往下
            for (i = startX; i < n - loop - 1; i++) {
                ans[i][n - loop - 1] = count++;
            }

            //下方从右往左
            for (i = n - loop - 1; i > startY; i--) {
                ans[n - loop - 1][i] = count++;
            }

            //左方从下往上
            for (i = n - loop - 1; i > startX; i--) {
                ans[i][startY] = count++;
            }
            startX++;
            startY++;
            loop++;
        }

        if (n % 2 == 1) {
            ans[startX][startY] = n * n;
        }
        return ans;
    }

}
