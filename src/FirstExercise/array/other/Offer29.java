package FirstExercise.array.other;

/**
 *  剑指 Offer 29 顺时针打印矩阵
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {

        if(matrix.length == 0) {
            return new int[]{};
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[] ans = new int[n * m];
        int loop = 0; //循环次数
        int startX = 0, startY = 0; //每个圈的起始位置
        int i;
        int count = 0;

        while (loop <= n / 2) {

            //模拟上方从左到右 遵循左闭右开
            for (i = startY; i < m - loop - 1 && count < ans.length; i++) {
                ans[count++] = matrix[startX][i];
            }

            //模拟右方从上往下
            for (i = startX; i < n - loop - 1 && count < ans.length; i++) {
                ans[count++] = matrix[i][m - loop - 1];
            }

            //下方从右往左
            for (i = m - loop - 1; i > startY && count < ans.length; i--) {
                ans[count++] = matrix[n - loop - 1][i];
            }

            //左方从下往上
            for (i = n - loop - 1; i > startX && count < ans.length; i--) {
                ans[count++] = matrix[i][startY];
            }
            startX++;
            startY++;
            loop++;
        }

        if ((n * m) % 2 == 1 && count < ans.length ) {
            ans[count] = matrix[--startX][--startY];
        }

        return ans;
    }
}
