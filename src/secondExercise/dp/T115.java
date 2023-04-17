package secondExercise.dp;

public class T115 {
    public int numDistinct(String s, String t) {
        char[] s_ch = s.toCharArray();
        char[] t_ch = t.toCharArray();
        int sLen = s_ch.length;
        int tLen = t_ch.length;
        // s的子序列里 t 出现的次数
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i < tLen + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < tLen + 1; j++) {
                if (s_ch[i - 1] == t_ch[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }
}
