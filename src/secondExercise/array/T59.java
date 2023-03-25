package secondExercise.array;

public class T59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int loop = 0;
        int i = 1;
        while (loop < n / 2) {

            for (int j = loop; j < n - loop - 1; j++) {
                ans[loop][j] = i++;
            }

            for (int j = loop; j < n - loop - 1; j++) {
                ans[j][n - 1 - loop] = i++;
            }

            for (int j = n - loop - 1; j > loop; j--) {
                ans[n - 1 - loop][j] = i++;
            }

            for (int j = n - 1 - loop; j > loop; j--) {
                ans[j][loop] = i++;
            }
            loop++;
        }
        if (n % 2 != 0) {
            ans[n / 2][n / 2] = n * n;
        }
        return ans;
    }
}
