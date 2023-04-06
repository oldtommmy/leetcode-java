package secondExercise.dp;

public class T474 {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        //遍历物品
        for (String str : strs) {
            char[] ch = str.toCharArray();
            int zero = 0, one = 0;
            for (char c : ch) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
