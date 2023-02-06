package FirstExercise.array.other;

import java.util.ArrayList;
import java.util.List;

public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new ArrayList<>();
        }

        int n = matrix.length;
        int m = matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        int loop = 0; //循环次数
        int startX = 0, startY = 0; //每个圈的起始位置
        int i;
        int count = 0;

        while (loop <= n / 2) {

            //模拟上方从左到右 遵循左闭右开
            for (i = startY; i < m - loop - 1 && ans.size() < n * m; i++) {
                ans.add(matrix[startX][i]);
            }

            //模拟右方从上往下
            for (i = startX; i < n - loop - 1 && ans.size() < n * m; i++) {
                ans.add(matrix[i][m - loop - 1]);
            }

            //下方从右往左
            for (i = m - loop - 1; i > startY && ans.size() < n * m; i--) {
                ans.add(matrix[n - loop - 1][i]);
            }

            //左方从下往上
            for (i = n - loop - 1; i > startX && ans.size() < n * m; i--) {
                ans.add(matrix[i][startY]);
            }
            startX++;
            startY++;
            loop++;
        }

        if ((n * m) % 2 == 1 && ans.size() < n * m ) {
            ans.add(matrix[--startX][--startY]);
        }

        return ans;
    }
}
